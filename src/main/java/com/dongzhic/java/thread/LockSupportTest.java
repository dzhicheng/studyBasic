package com.dongzhic.java.thread;

import org.apache.tools.ant.taskdefs.Sleep;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author dongzhic
 * @Date 3/10/21 11:46 AM
 */
public class LockSupportTest {

    public static void main(String[] args) {

//        ReentrantLock

        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i ++) {
                System.out.println(i);
                if (i == 5) {
                    LockSupport.park();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after 8 seconds!");

        LockSupport.unpark(t);
    }
}
