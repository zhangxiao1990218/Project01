package com.xiaotu.java;

/**
 *
 */
public class Person {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}


class  PersonTest{
    public static void main(String[] args) {

        Person p1 = new Person("张三",20);
        Person p2 = new Person("张三",20);
        p1.setName("李四");
        System.out.println(p2.getName());
        System.out.println(p1.getName().equals(p2.getName()));
        System.out.println(p1.getName() == p2.getName());
    }
}
