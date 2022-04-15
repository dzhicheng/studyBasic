package com.dongzhic.java.reflect.demo.demo2;

/**
 * @author dongzc
 * @date 2018/6/25 22:54
 */
public class ClassDemo2 {

    public static void main(String[] args) {
        Class c1 = int.class;
        Class c2 = Integer.class;
        Class c3 = String.class;
        Class c4 = double.class;
        Class c5 = Double.class;
        Class c6 = void.class;

        System.out.println(c1.getName());
        System.out.println(c2.getName());
        //不包含包名的类的名称
        System.out.println(c2.getSimpleName());
        System.out.println(c3.getName());
        System.out.println(c5.getName());
    }

}
