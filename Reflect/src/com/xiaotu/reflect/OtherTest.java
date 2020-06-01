package com.xiaotu.reflect;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author 张晓
 * @create 2020-04-28 11:29
 */
public class OtherTest {

    /***
     * 获取指定构造器
     */
    @Test
    public void test0() throws Exception {
        Class clazz = Person.class;
        Class clazz1 = Person.class;
        Constructor con = clazz.getDeclaredConstructor(String.class);
        con.setAccessible(true);
        Person p = (Person) con.newInstance("哈哈");
        System.out.println(p);

        Method show = clazz.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        Person p1 = new Person();

        show.invoke(p1,"邯郸");

    }


    /**
     * 获取构造器结构
     */

    @Test
    public void test1(){
        Class clazz = Person.class;
        //getConstructors():获取当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }

        System.out.println();

        //getDeclaredConstructors():获取当前运行时类中声明的所有的构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor d : declaredConstructors) {
            System.out.println(d);
        }

    }



    /**
     * 获取运行时类的父类
     */

    @Test
    public void test2(){
        Class clazz = Person.class;
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);

    }

    /**
     * 获取运行时类的带泛型的父类
     */

    @Test
    public void test3(){
        Class clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);

    }

    /**
     * 获取运行时类的带泛型的父类的泛型
     */

    @Test
    public void test4(){
        Class clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType pa = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = pa.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());

    }


    /***
     * 获取运行时类实现的接口
     */
    @Test
    public void test5(){
        Class clazz = Person.class;
        Class[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c);
        }

        System.out.println();
        /***
         * 获取运行时类的父类实现的接口
         */
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class c : interfaces1) {
            System.out.println(c);
        }


    }


    /***
     * 获取运行时类实现的接口
     */
    @Test
    public void test6(){
        Class clazz = Person.class;
        Package p = clazz.getPackage();
        String name = p.getName();
        System.out.println(name);

    }

    /***
     * 获取运行时类声明的注解
     */
    @Test
    public void test7(){
        Class clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation a : annotations) {
            System.out.println(a);
        }
    }


}
