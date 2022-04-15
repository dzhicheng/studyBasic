package com.dongzhic.java.thread.countDownLatch;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author dongzhic
 * @Date 5/14/21 7:36 PM
 */
@Slf4j
public class QueueTask implements Runnable {

    private CountDownLatch countDownLatch;

    public QueueTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        try {
            log.info("开水在医院药房排队买药。。。。");
            TimeUnit.SECONDS.sleep(5);
            log.info("排队成功，可以开始缴费买药");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }


    }
}
