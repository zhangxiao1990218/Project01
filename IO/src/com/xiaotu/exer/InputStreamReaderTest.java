package com.xiaotu.exer;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 处理流之二：转换流的使用
 * 1.转换流：属于字符流
 *      InputStreamReader ：将一个字节的输入流转换为字符的输入流
 *      OutputStreamWriter ：将一个字符的输出流转换为一个字节的输出流
 * 2.作用：提供字节流与字符流之间的转换
 *
 * 3.解码：字节，字节数组 ----> 字符，字符数组
 *   编码：字符，字符数组 ----> 字节，字节数组
 *
 * @author 张晓
 * @create 2020-04-26 17:49
 */
public class InputStreamReaderTest {

    @Test
    public void test1() throws FileNotFoundException {

        FileInputStream  fis = new FileInputStream("hello.txt");
        //InputStreamReader isr = new InputStreamReader(fis);//使用系统默认的字符集
        //参数2指明了字符集
        ///InputStreamReader isr = new InputStreamReader(fis,"UTF-8");


    }



}
