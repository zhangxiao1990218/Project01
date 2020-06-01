package com.xiaotu.exe1;

import java.util.Collection;
import java.util.List;

/**
 * @author 张晓
 * @create 2020-04-24 16:18
 */
public class Student{

    //学号
    private int stuId;

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public Student(int stuId) {
        this.stuId = stuId;
    }


    static A getAInstance(List list){
        return new A(list);
    }


    static class A extends B {
        final List list;

        A(List list){
            super(list);
            this.list = list;
        }

    }

    static class B{
        final Collection c;  // Backing Collection
        final Object mutex;     // Object on which to synchronize
        B(List list){
            c = list;
            mutex = this;
        }
    }


}
