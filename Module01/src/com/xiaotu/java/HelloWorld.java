package com.xiaotu.java;


public class HelloWorld {

    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "cd";
        String s3 = s1+s2;
        String s4 = "abcd";
        String s5 = "abcd";

        String s6 = s5.replace('a', 'b');

        char [] ch = new char[]{'1','2','3','4'};
        String str = new String(ch,1,2);
        System.out.println(str);


//        System.out.println(s5==s4);


    }


}
