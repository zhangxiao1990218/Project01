package com.xiaotu.exer;

import org.junit.Test;

import java.io.*;

/**
 * @author 张晓
 * @create 2020-04-26 16:11
 */
public class PictureTest {

    //图片的加密
    @Test
    public void test1(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(new File("周杰伦.jpeg"));
            fos = new FileOutputStream(new File("周杰伦secret.jpeg"));
            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer))!=-1){
                //字节数组进行修改
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                fos.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //图片的解密
    @Test
    public void test2(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(new File("周杰伦secret.jpeg"));
            fos = new FileOutputStream(new File("周杰伦3.jpeg"));
            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer))!=-1){
                //字节数组进行修改
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                fos.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }




}
