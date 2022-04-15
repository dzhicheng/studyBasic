package com.dongzhic.java.thread.sync;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author dongzhic
 * @Date 2021/10/29 12:04
 */
public class App {

    public static void main(String[] args) {

        MyObject object = new MyObject();

        ThreadA t1 = new ThreadA(object);
        t1.setName("A");
        t1.start();

        ThreadB t2 = new ThreadB(object);
        t2.setName("B");
        t2.start();


    }
}
