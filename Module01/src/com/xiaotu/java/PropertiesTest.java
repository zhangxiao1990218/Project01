package com.xiaotu.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author 张晓
 * @create 2020-04-24 10:28
 */
public class PropertiesTest {

    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("jdbc.properties");
        Properties pro = new Properties();
        pro.load(in);

        String name = pro.getProperty("name");
        String password = pro.getProperty("password");

        System.out.println("name = "+name + " ,password = " +password);
    }

    @Test
    public void test() throws IOException {
        FileInputStream in = new FileInputStream("jdbc.properties");
        Properties pro = new Properties();
        pro.load(in);

        String name = pro.getProperty("name");
        String password = pro.getProperty("password");

        System.out.println("name = "+name + " ,password = " +password);

    }

}
