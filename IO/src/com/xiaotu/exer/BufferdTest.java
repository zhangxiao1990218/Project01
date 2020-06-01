package com.xiaotu.exer;

import org.junit.Test;

import java.io.*;

/**
 *
 * 处理流之一：缓冲流的使用
 * 1.缓冲流
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2.作用：提高流的读取，写入的速度
 *   提高读写速度的原因：内部提供了一个缓冲区
 *
 *   3.处理流，就是“套接” 在已有的流的基础之上
 *
 * @author 张晓
 * @create 2020-04-26 13:41
 */
public class BufferdTest {


    /***
     * 实现非文本文件的复制
     */
    @Test
    public void testBufferedStream(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //1.创建文件
            File srcFile = new File("周杰伦.jpeg");
            File destFile = new File("周杰伦2.jpeg");
            //2.造流
            //2.1造节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3.复制的细节：读取，写入
            byte[] buffer = new byte[10];
            int len;
            while((len = bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            if(bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭可以省略
            //fos.close();
            //fis.close();
        }

    }


    //实现文件复制的方法
    public void copyFileBuffered(String srcPath,String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //1.创建文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //2.造流
            //2.1造节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3.复制的细节：读取，写入
            byte[] buffer = new byte[1024];
            int len;
            while((len = bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            if(bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭可以省略
            //fos.close();
            //fis.close();
        }
    }

    @Test
    public void testCopyFileWithBuffered(){

        long start = System.currentTimeMillis();

        String srcPath = "C:\\Users\\Administrator\\Desktop\\01-视频.wmv";
        String destPath = "C:\\Users\\Administrator\\Desktop\\03-视频.wmv";

        copyFileBuffered(srcPath,destPath);

        long end = System.currentTimeMillis();

        System.out.println("实现复制所消耗的时间："+(end-start));



    }


    /***
     * 使用BufferedReader 和 BufferedWriter 实现文本文件的复制
     */
    @Test
    public void testBufferedReaderBufferedWriter(){

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("html.txt")));
            bw = new BufferedWriter(new FileWriter(new File("html1.txt")));

            //读写操作
            //方式一
//            char[] cbuf = new char[1024];
//            int len;
//            while((len = br.read(cbuf))!=-1){
//                bw.write(cbuf,0,len);
//            }

            //方式二：使用String
            String data;
            while((data = br.readLine())!=null){
                //方法一
                //bw.write(data+"\n");
                //方法二
                bw.write(data);//data中不包含换行符
                bw.newLine();//换行符
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源关闭
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
