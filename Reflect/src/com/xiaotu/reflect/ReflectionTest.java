package com.xiaotu.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类指定的结构：属性，方法，构造器
 *
 * @author 张晓
 * @create 2020-04-28 13:51
 */
public class ReflectionTest {

    @Test
    public void testFiled() throws Exception {
        Class clazz = Person.class;
        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();
        //获取指定的属性:要求运行时类中的属性声明为public
        //通常不采用此方法
        Field id = clazz.getField("id");
        /**
         * 设置当前属性的值
         * set():参数1：指明设置哪个对象的属性 参数2：将此属性值设置为多少
         */
        id.set(p,1001);
        /**
         * 获取当前属性的值
         * get():参数1：获取哪个对象的当前属性值
         */
        int pId = (int) id.get(p);
        System.out.println(pId);

        //clazz.getDeclaredField("");
    }


    @Test
    public void testFiled1() throws Exception {
        Class clazz = Person.class;
        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();
        //1.getDeclaredField(String filedName):获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");

        //2.保证当前属性可访问的
        name.setAccessible(true);

        /**3.
         * 设置当前属性的值
         * set():参数1：指明设置哪个对象的属性 参数2：将此属性值设置为多少
         */
        name.set(p,"Tom");
        /**
         * 获取当前属性的值
         * get():参数1：获取哪个对象的当前属性值
         */
        String pName = (String) name.get(p);
        System.out.println(pName);

        //clazz.getDeclaredField("");
    }

    /**
     * 如何操作运行时类中的指定的方法
     */

    @Test
    public void testMethod() throws Exception {
        Class clazz = Person.class;
        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        /**
         * 1.获取指定的某个方法
         * getDeclaredMethod():参数1：指明获取的方法的名称  参数2：指明获取方法的参数列表
         */
        Method show = clazz.getDeclaredMethod("show", String.class);
        //2.保证当前方法是可访问的
        show.setAccessible(true);

        /**
         * invoke():参数1：方法的调用者  参数2：给方法形参赋值的实参
         * invoke()的返回值即为对应类中调用方法的返回值
         */
        Object returnValue = show.invoke(p,"CHN");
        System.out.println(returnValue);


        System.out.println("************************如何调用静态方法***********************");

        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //如果调用的运行时类中的方法没有返回值，则次invoke()返回null
        Object returnVal = showDesc.invoke(clazz);
        System.out.println(returnVal);

    }

    /**
     * 如何调用运行时类中的指定的构造器
     */
    @Test
    public void testConstructor() throws Exception {
        Class clazz = Person.class;
        /**
         * 1.获取指定的构造器
         * getDeclaredConstructor():参数1：指明构造器的参数列表
         */
        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);

        //2.保证此构造器是可访问的
        declaredConstructor.setAccessible(true);
        //3.调用此构造器创建运行时类的对象
        Person p = (Person) declaredConstructor.newInstance("Tom");
        System.out.println(p);
    }
}
