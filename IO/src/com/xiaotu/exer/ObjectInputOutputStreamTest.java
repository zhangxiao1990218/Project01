package com.xiaotu.exer;

import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用
 * 1.ObjectInputStream 和 ObjectOutputStream
 * 2.作用：用于存储和读取基本数据类型数据或对象的处理流，它的强大之处就是可以把java中的
 *      对象写入到数据源中，也能把对象从数据源中还原回来。
 * 3.要想一个java对象是可序列的，需要满足相应的要求。见Person.java
 *
 * 4.序列化机制：
 *  对象序列化机制允许把内存中的java对象转换成平台无关的二进制流，从而允许把这种
 *  二进制流持久的保存在磁盘上，或通过网络将这种二进制流传输到另一个网络节点，
 *  当其他程序获取了这种二进制流，就可以恢复成原来的java对象。
 *
 * @author 张晓
 * @create 2020-04-27 9:51
 */
public class ObjectInputOutputStreamTest {

    /**
     * 序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
     * 使用ObjectOutputStream实现
     */
    @Test
    public void testObjectOutputStream() throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
        oos.writeObject(new String("我爱北京天安门"));
        oos.flush();//刷新操作

        oos.writeObject(new Person("张三",19));
        oos.flush();

        oos.close();
    }


    /***
     * 反序列化过程:将磁盘文件中的对象还原为内存中的一个java对象
     * 使用ObjectInputStream实现
     */
    @Test
    public void testObjectInputStream() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.dat"));
        Object object = ois.readObject();
        String str = (String)object;
        System.out.println(str);
        Person p = (Person) ois.readObject();
        System.out.println(p);
        ois.close();
    }


}
