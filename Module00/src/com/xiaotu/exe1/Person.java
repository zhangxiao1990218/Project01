package com.xiaotu.exe1;

/**
 * @author 张晓
 * @create 2020-04-24 16:18
 */
public class Person {

    //姓名
    private String name;
    //年龄
    private int age;

    final Object obj;


    public Person(String name, int age) {
        obj = this;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
