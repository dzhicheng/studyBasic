package com.dongzhic.java.thread.countDownLatch;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 看医生的任务
 * @Author dongzhic
 * @Date 5/14/21 7:33 PM
 */
@Slf4j
public class SeeDoctorTask implements Runnable {

    private CountDownLatch countDownLatch;

    public SeeDoctorTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        try {
            log.info("开始看医生");
            TimeUnit.SECONDS.sleep(3);
            log.info("看医生结束，准备离开病房");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }

    }
}
