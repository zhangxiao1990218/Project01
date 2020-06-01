package com.xiaotu.exer;

import org.junit.Test;

import java.io.*;

/**
 * 测试FileInputStream和FileOutputStream的使用
 *
 * 结论：
 * 1.对于文本文件，使用字符流处理
 * 2.对于非文本文件，使用字节流处理
 *
 *
 * @author 张晓
 * @create 2020-04-26 11:20
 */
public class FileInputOutputStreamTest {

    //使用字节流FileInputStream处理文本文件，可能出现乱码。
    @Test
    public void testFileInputStream(){
        FileInputStream fis = null;
        try {
            //1.造文件
            File file = new File("hello.txt");
            //2.造流
            fis = new FileInputStream(file);
            //3.读数据
            byte[] buffer = new byte[5];
            int len;//记录每次读取的字节的个数
            while((len=fis.read(buffer))!=-1){
                String str = new String(buffer,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源
            try {
                if(fis!=null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 实现对图片的复制操作
     */
    @Test
    public void testFileInputOutputStream(){
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            //1.
            File srcFile = new File("周杰伦.jpeg");
            File destFile = new File("周杰伦1.jpeg");

            //2.
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //3.复制的操作
            byte[] buffer = new byte[5];
            int len;
            while((len = fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.
            try {
                if(fos!=null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fis!=null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testCopyFile(){

        long start = System.currentTimeMillis();

        String srcFile = "C:\\Users\\Administrator\\Desktop\\01-视频.wmv";
        String destFile = "C:\\Users\\Administrator\\Desktop\\02-视频.wmv";
        copyFile(srcFile,destFile);

        long end = System.currentTimeMillis();

        System.out.println("实现复制所消耗的时间："+(end-start));

    }



    /***
     * 指定路径下文件的复制
     */

    public void copyFile(String srcPath,String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            //1.
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //2.
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //3.复制的操作
            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.
            try {
                if(fos!=null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fis!=null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
