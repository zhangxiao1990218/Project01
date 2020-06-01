package com.xiaotu.java1;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一，构造器引用
 *
 *      和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致。
 *      抽象方法的返回值类型即为构造器所属的类的类型
 *
 * 二，数组引用
 *
 *      大家可以把数组看做是一个特殊的类，则写法与构造器引用一致。
 * @author 张晓
 * @create 2020-04-29 14:20
 */
public class ConstructorRefTest {

    /**
     * 构造器引用
     * Supplier 中的 T get()
     */
    @Test
    public void test1(){
        Supplier<Employee> sup = () -> new Employee();
        System.out.println(sup.get());

        System.out.println("*********************");

        Supplier<Employee> sup1 = Employee::new;
        System.out.println(sup1.get());
    }


    /**
     * Function 中的 R apply(T t)
     */
    @Test
    public void test2(){
        Function<Integer,Employee> fun = i -> new Employee(i);
        Employee employee = fun.apply(1001);
        System.out.println(employee);

        System.out.println("*********************");

        Function<Integer,Employee> fun1 = Employee::new;
        Employee employee1 = fun.apply(1002);
        System.out.println(employee1);
    }

    /**
     * BiFunction 中的R apply(T t,U u)
     *
     */
    @Test
    public void test3(){
        BiFunction<Integer,String,Employee> bifun = (i,s) -> new Employee(i,s);
        Employee em = bifun.apply(1999, "周华健");
        System.out.println(em);

        System.out.println("*********************");

        BiFunction<Integer,String,Employee> bifun1 = Employee::new;
        System.out.println(bifun1.apply(2000, "周华健1"));
    }

    /**
     * 数组引用
     * Function 中的 R apply(T t)
     */

    @Test
    public void test4(){
        Function<Integer,String[]> fun = len -> new String[len];
        String[] apply = fun.apply(3);
        System.out.println(Arrays.toString(apply));

        System.out.println("*********************");

        Function<Integer,String[]> fun1 = String[]::new;

        String[] apply1 = fun1.apply(5);
        System.out.println(Arrays.toString(apply1));

    }
}
