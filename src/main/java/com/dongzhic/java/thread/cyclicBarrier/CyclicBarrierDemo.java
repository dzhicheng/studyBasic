package com.dongzhic.java.thread.cyclicBarrier;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author dongzhic
 * @Date 5/14/21 7:53 PM
 */
@Slf4j
public class CyclicBarrierDemo {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(11, new Runnable() {
            @Override
            public void run() {
                log.info("所有特工到达屏障，准备开始执行秘密任务");
            }
        });

        for (int i = 0; i < 10; i ++) {
            new Thread(new CyclicBarrierRunner(cyclicBarrier, i)).start();
        }

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        log.info("全部到达屏障....");

    }
}
