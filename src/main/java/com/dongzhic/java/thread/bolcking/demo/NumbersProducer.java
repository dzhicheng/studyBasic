package com.dongzhic.java.thread.bolcking.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 生产者
 * @Author dongzhic
 * @Date 5/12/21 9:36 PM
 */
@Slf4j
public class NumbersProducer implements Runnable {

    private BlockingQueue<Integer> numbersQueue;
    /**
     * 药丸
     */
    private final int poisonPill;
    /**
     * 加毒药的次数
     */
    private final int poisonPillPerProducer;


    public NumbersProducer(BlockingQueue<Integer> numbersQueue,
                           int poisonPill, int poisonPillPerProducer) {
        this.numbersQueue = numbersQueue;
        this.poisonPill = poisonPill;
        this.poisonPillPerProducer = poisonPillPerProducer;
    }

    @Override
    public void run() {
        try {
            generateNumbers();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 生产100个元素
     * @throws InterruptedException
     */
    private void generateNumbers() throws InterruptedException {
        for (int i = 0; i < 100; i ++) {
            numbersQueue.put(ThreadLocalRandom.current().nextInt(100));
            log.info("潘金莲-{}号，给武大郎的泡药！", Thread.currentThread().getId());
        }

        for (int j = 0; j < poisonPillPerProducer; j ++) {
            numbersQueue.put(poisonPill);
            log.info("潘金莲-{}号，往武大郎的药里放入第{}颗毒丸！",
                    Thread.currentThread().getId(),
                    j+1);
        }
    }
}
