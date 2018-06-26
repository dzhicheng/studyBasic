package com.dongzhic.java.reflect.demo3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author dongzc
 * @date 2018/6/26 19:52
 */
public class MethodDemo2 {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("hello");

        Class c1 = list.getClass();
        Class c2 = list1.getClass();
        System.out.println(c1 == c2);
        //反射的操作都是编译的操作

        /**
         * c1 == c2 返回true表示编译之后的结合泛型是去泛型化
         * java中集合的泛型，只在编译阶段有效，绕过编译失效
         */
        try {
            Method m = c2.getMethod("add", Object.class);
            //绕过了编译就绕过了泛型
            m.invoke(list1, 2);
            System.out.println(list1.size());
            System.out.println(list1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
