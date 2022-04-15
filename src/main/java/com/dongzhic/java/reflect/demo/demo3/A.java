package com.dongzhic.java.reflect.demo.demo3;

/**
 * @author dongzc
 * @date 2018/6/26 18:35
 */
public class A {

    public void print () {
        System.out.println("Hello World!");
    }

    public void print (int a, int b) {
        System.out.println(a+b);
    }

    public void print (String a, String b) {
        System.out.println(a.toUpperCase()+","+b.toLowerCase());
    }

}

