package com.xiaotu.java2;

import com.xiaotu.java1.Employee;
import com.xiaotu.java1.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 测试Stream的终止操作
 *
 * @author 张晓
 * @create 2020-04-30 16:40
 */
public class StreamAPITest2 {
    //1-匹配与查找
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
        //allMatch(Predicate p):检查是否匹配所有元素。
        //练习：是否所有的员工的年龄都大于18
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        //anyMatch(Predicate p):检查是否至少匹配一个元素。
        System.out.println(allMatch);
        System.out.println("****************************");
        //练习:是否存在员工的工资大于10000
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 9876);
        System.out.println(anyMatch);
        System.out.println("****************************");
        //noneMatch(Predicate p):检查是否没有匹配的元素。
        //练习：是否存在员工姓”雷“
        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(noneMatch);
        System.out.println("****************************");
        //findFirst:返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);
        System.out.println("****************************");
        //fandAny:返回当前流中的任意元素
        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println(any);

    }

    @Test
    public void test2(){
        List<Employee> employees = EmployeeData.getEmployees();
        //count:返回流中元素的总个数
        long count = employees.stream().filter(e -> e.getSalary()>5000).count();
        System.out.println(count);
        System.out.println("****************************");
        //max(Comparator c):返回流中的最大值
        //练习：返回最高的工资
//        Optional<Double> first = employees.stream().map(e -> e.getSalary()).sorted((d1, d2) -> -Double.compare(d1, d2)).findFirst();
//        System.out.println(first.get());
        Optional<Double> max = employees.stream().map(e -> e.getSalary()).max(Double::compareTo);
        System.out.println(max.get());
        System.out.println("****************************");
        //min(Comparator c):返回流中的最小值
        //练习：返回最低工资的员工
//        Optional<Employee> min = employees.stream().sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).findFirst();
//        System.out.println(min.get());
        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min.get());
        System.out.println("****************************");
        //forEach(Consumer c):内部迭代99
        employees.stream().forEach(System.out::println);
        //使用集合的遍历操作
        employees.forEach(System.out::println);
    }
    //2：归约
    @Test
    public void test3(){
        //reduce(T iden,BinaryOperator b):可以将流中元素反复结合起来，得到一个值。返回T
        //练习1：计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //list.stream().reduce(0,)
        //reduce(BinaryOperator b):可以将流中元素反复结合起来，得到一个值。返回Optional<T>
        //练习2：计算公司所有员工工资的总和
    }
}
