package com.dongzhic.java.thread;

import lombok.Synchronized;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author dongzhic
 * @Date 5/7/21 1:59 PM
 */
public class AtomicTest {

    private static int counter = 0;

    public static void main(String[] args) {

        for (int i = 0; i < 10; i ++) {
            Thread thread = new Thread(() -> {
               for (int j = 0; j < 1000; j ++) {
                   counter++;
               }
            });
            thread.start();
        }

        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter);
    }


}
