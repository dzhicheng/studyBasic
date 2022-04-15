package com.dongzhic.java.thread.cyclicBarrier;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author dongzhic
 * @Date 5/14/21 7:53 PM
 */
@Slf4j
public class CyclicBarrierRunner implements Runnable {

    private CyclicBarrier cyclicBarrier;

    private int index;

    public CyclicBarrierRunner(CyclicBarrier cyclicBarrier, int index) {
        this.cyclicBarrier = cyclicBarrier;
        this.index = index;
    }

    @Override
    public void run() {

        log.info("index: " + index);
        index--;
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
