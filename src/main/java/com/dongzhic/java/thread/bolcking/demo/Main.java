package com.dongzhic.java.thread.bolcking.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author dongzhic
 * @Date 5/12/21 9:50 PM
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Thread.interrupted();



        // 队列的大小
        int BOUND = 10;
        int N_PRODUCERS = 16;
        int N_CONSUMERS = Runtime.getRuntime().availableProcessors();
        // 药丸编号
        int poisonPill = Integer.MAX_VALUE;
        // 生产药丸的次数
        int poisonPillPerProducer = N_CONSUMERS / N_PRODUCERS;
        int mod = N_CONSUMERS % N_PRODUCERS;

//        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(BOUND);
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(BOUND);

        // 潘金莲给武大郎熬药
        for (int i = 0; i < N_PRODUCERS; i ++) {
            new Thread(new NumbersProducer(queue, poisonPill, poisonPillPerProducer)).start();
        }

        // 武大郎开始喝药
        for (int j = 0; j < N_CONSUMERS; j ++) {
            new Thread(new NumbersConsumer(queue, poisonPill)).start();
        }

        TimeUnit.SECONDS.sleep(5);

        // 潘金莲开始投毒，武大郎喝完毒药GG
        new Thread(new NumbersProducer(queue, poisonPill,
                poisonPillPerProducer+ mod)).start();


    }

}
