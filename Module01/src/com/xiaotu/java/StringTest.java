package com.xiaotu.java;

import org.junit.Test;

/**
 * @author 张晓
 * @create 2020-04-20 14:58
 */
public class StringTest {


    @Test
    public void test(){
        String s1 = "abc";
        String s2 = "def";
        String s3 = "abcdef";
        String s4 = "abc"+"def";
        String s5 = s1 + "def";
        String s6 = "abc" + s2;
        String s7 = s1 + s2;
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);
        System.out.println(s3 == s7);
        System.out.println(s5 == s6);
        System.out.println(s5 == s7);
        System.out.println(s6 == s7);
        String s8 = s5.intern();
        System.out.println(s8 == s3);


    }
}
