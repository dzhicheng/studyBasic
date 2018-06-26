package com.dongzhic.java.reflect.demo3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author dongzc
 * @date 2018/6/26 18:43
 */
public class MethodDemo1 {

    public static void main(String[] args) {
        //获取print(int a, int b)方法

        A a1 = new A();
        //1.获取一个方法就要获取类的信息，获取类的信息，需要获取类的类类型
        Class c = a1.getClass();

        /**
         * 2.获取方法：有方法名、参数列表决定
         *  getMethod()：获取public的方法
         *  getDeclaredFields()：获取自己声明的方法
         */
        Method m1 = null;
        Method m2 = null;
        Method m3 = null;
        try {
//            m1 = c.getMethod("print", new Class[]{int.class, int.class});
            m1 = c.getMethod("print", int.class, int.class);

            //方法的反射操作是用m对象进行的方法调用和a1.print()调用的效果相同
//            a1.print(10,20);
//          Object o = m1.invoke(a1, new Object[]{10, 20});
            //方法没有返回值返回null,有返回值返回具体的返回值
            Object o = m1.invoke(a1, 10, 20);
            System.out.println("==================");

            m2 = c.getMethod("print", String.class, String.class);
            m2.invoke(a1, "dong", "ZHICHENG");

            System.out.println("==================");

            m3 = c.getMethod("print");
            m3.invoke(a1);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
