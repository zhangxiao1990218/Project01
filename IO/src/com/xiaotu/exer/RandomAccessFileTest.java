package com.xiaotu.exer;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile的使用：
 * 1.RandomAccessFile 直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 * 2.RandomAccessFile 既可以作为一个输入流，又可以作为一个输出流
 *
 * 3.如果RandomAccessFile作为一个输出流时，写出到的文件如果不存在，则在执行过程中自动创建
 *              如果写出到的文件存在，则会对原有的文件内容进行覆盖。（默认情况下，从头覆盖）
 *
 * 4.可以通过相关操作，实现RandomAccessFile"插入"数据的效果
 * @author 张晓
 * @create 2020-04-27 11:16
 */
public class RandomAccessFileTest {

    @Test
    public void test1() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile(new File("周杰伦.jpeg"),"r");
        RandomAccessFile raf2 = new RandomAccessFile(new File("周杰伦4.jpeg"),"rw");

        byte[] buff = new byte[1024];
        int len;
        while((len = raf1.read(buff))!=-1){
            raf2.write(buff,0,len);
        }

        raf1.close();
        raf2.close();

    }

    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile(new File("hehe.txt"),"rw");
        raf1.seek(3);//将指针调到角标为3的位置
        raf1.write("xyz".getBytes());
        raf1.close();
    }

    /**
     * 使用RandomAccessFile实现数据插入的效果
     */
    @Test
    public void test3() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile(new File("hehe.txt"),"rw");
        raf1.seek(3);//将指针调到角标为3的位置
        //保存指针3后面的所有数据
        StringBuilder sb = new StringBuilder((int)new File("hehe.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while((len = raf1.read(buffer))!=-1){
            sb.append(new String(buffer,0,len));
        }
        //调回指针，写入"xyz"
        raf1.seek(3);
        raf1.write("xyz".getBytes());
        //将StringBuilder中的数据写入到文件中
        raf1.write(sb.toString().getBytes());
        raf1.close();

        //思考：将StringBuilder替换为ByteArrayOutputStream




    }

}
