package com.dongzhic.java.thread;

/**
 * @Author dongzhic
 * @Date 2021/10/28 21:01
 */
public class SingletBean {

    private static final SynchronizedDemo test = new SynchronizedDemo();

    public SynchronizedDemo getBean () {
        return test;
    }
}
