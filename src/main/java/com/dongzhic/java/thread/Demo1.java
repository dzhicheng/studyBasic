package com.dongzhic.java.thread;

/**
 * @Author dongzhic
 * @Date 2021/10/28 20:58
 */
public class Demo1 {

    public static void main(String[] args) {
        SingletBean test = new SingletBean();

        new Thread(() -> {
            test.getBean().a();
        }, "thread1").start();
    }
}
