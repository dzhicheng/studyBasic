package com.dongzhic.jvm;

import sun.misc.Launcher;

/**
 * 计算对象大小
 * @Author dongzhic
 * @Date 3/25/21 4:11 PM
 */
public class JOLSample {

    public static void main(String[] args) {

        String s1 = new String("he") + new String("llo");
        String s2 = s1.intern();

        System.out.println(s1 == s2);

        Integer.valueOf(1);

    }


    public static class A {

        int id;
        String name;
        byte b;
        Object o;
    }


}

