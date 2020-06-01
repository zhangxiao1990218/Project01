package com.xiaotu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**集合元素的遍历，使用迭代器Iterator接口
 * @author 张晓
 * @create 2020-04-22 15:13
 */
public class IteratorTest {

    @Test
    public void test(){

        Collection list = new ArrayList();
        list.add(new Student("李四",18));
        list.add(123);
        list.add(new String("张三"));
        list.add(456);
        list.add(false);

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }


    @Test
    public void testRemove(){
        Collection list = new ArrayList();
        list.add(new Student("李四",18));
        list.add(123);
        list.add(new String("张三"));
        list.add(456);
        list.add(false);

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            if ("张三".equals(obj)){
                iterator.remove();
            }
        }
        //从新遍历
        Iterator iterator1 = list.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

    }



    //测试题
    @Test
    public void test3(){
        String [] arr = new String[]{"MM","MM","MM"};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "GG";
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

}
