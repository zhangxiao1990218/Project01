package com.xiaotu.java1;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 *
 * 1.使用情景：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用。
 * 2.方法引用：本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例。
 *      所以方法引用，也是函数式接口的实例。
 *
 * 3.使用格式： 类（或对象）:: 方法名
 * 4.具体分为如下的三种情况：
 *   情况1 对象 :: 非静态方法
 *   情况2 类  :: 静态方法
 *   情况3 类 :: 非静态方法
 *
 * 5.方法引用使用的要求：
 *      要求接口中的抽象方法的形参列表和返回值类型与方法引用的
 *          形参列表和返回值类型相同（针对于情况1 和 情况2）
 * @author 张晓
 * @create 2020-04-29 10:41
 */
public class MethodRefTest {

    /**
     * 情况一：对象 :: 实例方法
     * Consumer 中的 void accept(T t)
     * PrintStream 中的 void println(T t)
     */
    @Test
    public void test1(){
        Consumer<String> con = str -> System.out.println(str);
        con.accept("北京");

        System.out.println("**************************");

        PrintStream ps = System.out;
        Consumer<String> con1 = ps :: println;
        con1.accept("beijing");

    }

    /**
     * Supplier 中的T get()
     * Employee 中的String getName()
     */

    @Test
    public void test2(){
        Employee em = new Employee(1001,"Tom",23,5600);
        Supplier<String> sup = () -> em.getName();
        System.out.println(sup.get());

        System.out.println("**************************");

        Supplier<String> sup1 = em::getName;
        System.out.println(sup1.get());

    }

    /**
     * 情况二：类 :: 静态方法
     * Comparator 中的int compare(T t1,T t2)
     * Integer 中的int compare(T t1,T t2)
     */
    @Test
    public void test3(){
        Comparator<Integer> com = (t1,t2) -> Integer.compare(t1,t2);
        System.out.println(com.compare(12, 21));

        System.out.println("**************************");

        Comparator<Integer> com1 = Integer::compare;
        System.out.println(com1.compare(21,12));

    }


    /**
     * Function 中的 R apply(T t)
     * Math 中的Long round(Double d)
     */
    @Test
    public void test4(){
        Function<Double,Long> func = d -> Math.round(d);
        System.out.println(func.apply(12.3));
        System.out.println("**************************");

        Function<Double,Long> func1 = Math::round;
        System.out.println(func1.apply(13.5));
    }

    /***
     * 情况三：类 :: 实例方法 (有难度)
     * Comparator 中的 int compare(T t1,T t2)
     * String 中的 int t1.compareTo(t2)
     */

    @Test
    public void test5(){
        Comparator<String> com = (s1,s2) -> s1.compareTo(s2);
        System.out.println(com.compare("abc", "abd"));

        System.out.println("**************************");

        Comparator<String> com1 = String :: compareTo;
        System.out.println(com1.compare("c","b"));

    }

    /***
     * BiPredicate 中的 boolean test(T t1,T t2)
     * String 中的 boolean t1.equals(t2)
     */
    @Test
    public void test6(){
        BiPredicate<String,String> bi = (s1,s2) -> s1.equals(s2);
        System.out.println(bi.test("a", "a"));

        System.out.println("**************************");

        BiPredicate<String,String> bi1 = String ::equals;
        System.out.println(bi1.test("c","d"));
    }

    /**
     * Function 中的R apply(T t)
     * Employee 中的 String getName()
     */

    @Test
    public void test7(){
        Function<Employee,String> fun = e -> e.getName();
        System.out.println(fun.apply(new Employee(1002, "马云", 34, 8800.98)));

        System.out.println("**************************");

        Function<Employee,String> fun1 = Employee::getName;
        System.out.println(fun1.apply(new Employee(1002, "马云1", 34, 8800.98)));

    }

}
