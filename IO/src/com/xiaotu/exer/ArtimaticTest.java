package com.xiaotu.exer;

import org.junit.Test;

/**
 * @author 张晓
 * @create 2020-04-26 16:35
 */
public class ArtimaticTest {

    //异或运算 ^:其运算规则是:在两个二进制操作数的相同位中，相同则结果为0，不同则结果为1。
    @Test
    public void test(){
        int a = 4;
        int b = 9;
        System.out.println(a^b);
        System.out.println(a^b^b);
    }


}
