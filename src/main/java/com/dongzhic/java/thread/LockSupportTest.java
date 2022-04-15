package com.dongzhic.java.thread;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author dongzhic
 * @Date 3/10/21 11:46 AM
 */
@Slf4j
public class LockSupportTest {

    public static void main(String[] args) {


        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();





        LockSupport.park();
        LockSupport.unpark(Thread.currentThread());

        Logger logger = LoggerFactory.getLogger(LockSupportTest.class);


        Thread t1 = new Thread(() -> {
//            Thread current = Thred.
        });

        t1.start();

        try {
            logger.info("准备唤醒{}线程！", t1.getName());
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public  void test1 () {
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
