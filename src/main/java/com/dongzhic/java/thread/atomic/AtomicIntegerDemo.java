package com.dongzhic.java.thread.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author dongzhic
 * @Date 5/14/21 10:11 PM
 */
public class AtomicIntegerDemo {

    static AtomicInteger atomic = new AtomicInteger(0);

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i ++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j ++) {
                    atomic.getAndIncrement();
                }
                countDownLatch.countDown();
            }).start();
        }

        try {
            countDownLatch.await();
            System.out.println(atomic.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
