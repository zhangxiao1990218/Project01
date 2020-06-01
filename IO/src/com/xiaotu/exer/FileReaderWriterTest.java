package com.xiaotu.exer;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 张晓
 * @create 2020-04-26 9:34
 */
public class FileReaderWriterTest {


    /**
     * 从内存中写出数据到硬盘的文件里。
     *
     * 说明：
     * 1.输出操作，对应的File可以不存在的。并不会报异常
     *
     * 2.
     * File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
     * File对应的硬盘中的文件如果存在:
     *          如果流使用的构造器是：FileWriter(file,false) / FileWriter(file) :对原有文件的覆盖
     *          如果流使用的构造器是：FileWriter(file,true) :不会对原有文件覆盖，而是在原有文件基础上追加内容
     */
    @Test
    public void testFileWriter(){
        FileWriter fw = null;
        try {
            //1.提供File类的对象，指明写出到的文件
            File file = new File("hello1.txt");
            //2.提供FileWriter的对象，用于写出数据
            fw = new FileWriter(file);

            //3.写出的操作
            fw.write("I have a dream!\n");
            fw.write("you need to have a dream!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fw!=null)
            //4.流资源的关闭
            {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    /***
     *  不能使用字符流来处理图片等字节数据
     */
    @Test
    public void testFileReaderFileWriter(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.创建File类的对象，指明读入和写出的文件
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2.txt");
            //2.创建输入，输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);
            //3.数据的读入和写出操作
            char[] cbuf = new char[5];
            int len;//记录每次读入到cbuf数组中的字符的个数、
            while((len = fr.read(cbuf))!=-1){
                //每次写出len个字符
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            try {
                if(fw!=null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fr!=null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }



}
