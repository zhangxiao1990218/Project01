package com.xiaotu.java;

import org.junit.Test;

import java.util.*;

/**
 *
 * Collection接口中声明的方法的测试
 * 向Collection接口的实现类的对象中添加数据obj时,要求obj所在类要重写equals()方法。
 * @author 张晓
 * @create 2020-04-22 10:43
 */
public class CollectionTest {

    @Test
    public void testContains(){
        Collection list = new ArrayList();
        list.add(new Student("李四",18));
        list.add(123);
        list.add(new String("张三"));
        list.add(123);
        Student s = new Student("王五", 18);
        list.add(s);
        //1.contains(Object obj)
        //我们在判断时会调用obj对象所在类的equals()
        //System.out.println(list.contains(new String("张三")));
        //System.out.println(list.contains(s));
        System.out.println(list.contains(new Student("李四",18)));
        //2.containsAll(Collection coll):判断形参coll中的所有元素是否都存在于当前集合中。
        //List list1 = Arrays.asList(new int[]{123,123});//false
        //List list1 = Arrays.asList(123,123);//相当于装箱操作
        List list1 = Arrays.asList(new Integer[]{123,123});
        System.out.println(list.containsAll(list1));
    }

    @Test
    public void testRemove(){
        //3.remove(Object obj)
        Collection list = new ArrayList();
        list.add(new Student("李四",18));
        list.add(123);
        list.add(new String("张三"));
        list.add(456);
        list.add(false);

        //System.out.println(list.remove(new Integer(123)));
        System.out.println(list.remove(123));
        System.out.println(list);
        System.out.println(new Student("李四",18));
        System.out.println(list);

        //4.removeAll()
        Collection co = new ArrayList();
        co.add(123);
        co.add(456);
        list.removeAll(co);
        System.out.println(list);

    }

    @Test
    public void testRetainAll(){
        Collection list = new ArrayList();
        list.add(new Student("李四",18));
        list.add(123);
        list.add(new String("张三"));
        list.add(456);
        list.add(false);




//        Collection co = new ArrayList();
//        co.add(123);
//        co.add(456);
//
//        5.retainAll(Collection co) :交集：获取当前集合和co集合的交集，并返回给当前集合
//        list.retainAll(co);
//        System.out.println(list);


        //6.equals(Object obj) :要想返回true,需要当前集合和形参集合的元素都相同

        Collection list1 = new ArrayList();
        list1.add(new Student("李四",18));
        list1.add(123);
        list1.add(new String("张三"));
        list1.add(456);
        list1.add(false);

        System.out.println(list.equals(list1));

    }

    @Test
    public void testHashCode(){
        Collection list = new ArrayList();
        list.add(new Student("李四",18));
        list.add(123);
        list.add(new String("张三"));
        list.add(456);
        list.add(false);

        //7.hashCode():返回当前对象的哈希值
//        System.out.println(list.hashCode());

        //8.集合--->数组:toArray()
//        Object[] objects = list.toArray();
//        for (int i = 0; i < objects.length; i++) {
//            System.out.println(objects[i]);
//        }

        //9.iterator():返回Iterator接口的实例,用于遍历集合元素。
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }

    }

}
