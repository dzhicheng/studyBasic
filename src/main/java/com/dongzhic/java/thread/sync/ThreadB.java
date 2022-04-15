package com.dongzhic.java.thread.sync;

/**
 * @Author dongzhic
 * @Date 2021/10/29 12:02
 */
public class ThreadB extends Thread{

    private MyObject object;

    public ThreadB(MyObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodB();
    }
}
