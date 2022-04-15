package com.dongzhic.java.thread;

/**
 *
 * @Author dongzhic
 * @Date 2021/10/28 20:54
 */
public class SynchronizedDemo {

    public synchronized void a () {
        System.out.println("===================a===================");
    }

    public synchronized void b () {
        System.out.println("===================b===================");
    }
}
