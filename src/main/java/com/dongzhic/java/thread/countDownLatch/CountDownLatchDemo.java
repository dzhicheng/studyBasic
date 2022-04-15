package com.dongzhic.java.thread.countDownLatch;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * @Author dongzhic
 * @Date 5/14/21 7:31 PM
 */
@Slf4j
public class CountDownLatchDemo {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(new SeeDoctorTask(countDownLatch)).start();
        new Thread(new QueueTask(countDownLatch)).start();

        try {
            // 等待线程池中2个任务执行完毕，否则一直等待
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        log.info("over, 回家 cost:" + (end - start));

    }
}
