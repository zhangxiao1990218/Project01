package com.xiaotu.exer;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例题3：从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端，并关闭相应的链接。
 *
 * @author 张晓
 * @create 2020-04-27 16:39
 */
public class TCPtest3 {

    @Test
    public void client() {
        Socket socket = null;
        OutputStream out = null;
        FileInputStream fis = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
            out = socket.getOutputStream();
            fis = new FileInputStream(new File("美女.jpg"));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer))!=-1){
                out.write(buffer,0,len);
            }

            //关闭数据的输出
            socket.shutdownOutput();

            //接收来自服务器端的数据，并显示到控制台上
            InputStream is = socket.getInputStream();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            buffer = new byte[5];
            len = 0;
            while ((len = is.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
            System.out.println(bos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis!=null){

                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null){

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }


    @Test
    public void server() {
        ServerSocket ss = null;
        InputStream is = null;
        FileOutputStream fos = null;
        Socket socket = null;
        try {
            ss = new ServerSocket(9090);
            socket = ss.accept();
            is = socket.getInputStream();
            fos = new FileOutputStream(new File("美女2.jpg"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }

            //服务器端给予客户端反馈
            OutputStream os = socket.getOutputStream();
            os.write("你好，美女，照片我已收到，非常漂亮".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}
