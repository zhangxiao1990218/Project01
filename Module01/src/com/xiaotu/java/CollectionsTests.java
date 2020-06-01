package com.xiaotu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 张晓
 * @create 2020-04-24 13:27
 */
public class CollectionsTests {

    @Test
    public void test(){
        List list = new ArrayList();
        list.add(123);
        list.add(1);
        list.add(12);
        list.add(53);
        list.add(78);
        list.add(789);

//        List list1 = Arrays.asList(new Object[list.size()]);
//        int size = list1.size();
//        Collections.copy(list1,list);
//        System.out.println(list1);

        /***
         * Collections 类中提供了多个 synchronizedXxx() 方法，
         * 该方法可使指定集合包装成线程同步的集合，从而可以解决
         * 多线程并发访问集合时的线程安全问题。
         */

        //返回的list1即为线程安全的list
        List list1 = Collections.synchronizedList(list);
        list1.hashCode();

    }

}
