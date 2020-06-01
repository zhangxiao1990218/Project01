package com.xiaotu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *      |----List接口：存储有序的，可重复的数据。-->“动态”数组
 * 		        |----ArrayList,LinkedList,Vector
 *
 * @author 张晓
 * @create 2020-04-22 16:18
 */
public class ListTest {

    //List接口中的常用方法

    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Student("张三",18));
        list.add(123);
        list.add(456);

        //4.int indexOf(Object obj):返回obj在集合中首次出现的位置
        //System.out.println(list.indexOf(123));

        //5.int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        //System.out.println(list.lastIndexOf(123));

        //6.Object remove(int index):移除指定index位置的元素，并返回此元素
        //Object remove = list.remove(1);
        //System.out.println(remove);
        //System.out.println(list);

        //7.Object set(int index,Object ele):设置指定index位置的元素为ele
        //list.set(1,999);
        //System.out.println(list);

        //8.List subList(int fromIndex,int toIndex):返回从fromIndex到toIndex位置的子集

    }



    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Student("张三",18));
        list.add(123);
        list.add(456);

        //1.void add(int index,Object ele):在index位置插入ele元素
        list.add(1,"BB");
        //System.out.println(list);

        //2.boolean addAll(int index,Collection eles):从index位置开始将eles中的所有的元素添加进来
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        list.addAll(0,list1);
        //System.out.println(list);

        //3.Object get(int index):获取指定index位置的元素
        System.out.println(list.get(1));


    }


}
