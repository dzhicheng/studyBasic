package com.dongzhic.java.thread.pool;

import com.sun.org.apache.xerces.internal.impl.dv.xs.BaseDVFactory;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 核心线程数为0，最大线程数为5，阻塞队列是10，丢任务可以跑起来吗
 * @Author dongzhic
 * @Date 6/18/21 1:36 PM
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(0, 5, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(4));

        poolExecutor.allowCoreThreadTimeOut(true);
        System.out.println("test start" + new Date() + "   " + Thread.currentThread().getName());

        try {
            for (int i = 0; i < 6; i++) {
                poolExecutor.execute(() -> {
                    System.out.println("work start  " + new Date() + "   " + Thread.currentThread().getName());
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("work ned  " + new Date() + "   " + Thread.currentThread().getName());
                });
            }

            TimeUnit.SECONDS.sleep(3);
            System.out.println("。。。。。。。。。。。1  " + new Date() + "  " + poolExecutor.getActiveCount());
            System.out.println("。。。。。。。。。。。1  " + new Date() + "  " + poolExecutor.getPoolSize());
            System.out.println("。。。。。。。。。。。1  " + new Date() + "  " + poolExecutor.getTaskCount());
            System.out.println("。。。。。。。。。。。1  " + new Date() + "  " + poolExecutor.getQueue().size());
            System.out.println("。。。。。。。。。。。1" + new Date() + "  ");
            Thread.sleep(4000);
            System.out.println("。。。。。。。。。。。2  " + new Date() + "  " + poolExecutor.getActiveCount());
            System.out.println("。。。。。。。。。。。2  " + new Date() + "  " + poolExecutor.getPoolSize());
            System.out.println("。。。。。。。。。。。2  " + new Date() + "  " + poolExecutor.getTaskCount());
            System.out.println("。。。。。。。。。。。2  " + new Date() + "  " + poolExecutor.getQueue().size());
            System.out.println("。。。。。。。。。。。2  " + new Date() + "  ");
            Thread.sleep(20000);
            System.out.println("。。。。。。。。。。。3  " + new Date() + "  " + poolExecutor.getActiveCount());
            System.out.println("。。。。。。。。。。。3  " + new Date() + "  " + poolExecutor.getPoolSize());
            System.out.println("。。。。。。。。。。。3  " + new Date() + "  " + poolExecutor.getTaskCount());
            System.out.println("。。。。。。。。。。。3  " + new Date() + "  " + poolExecutor.getQueue().size());
            System.out.println("。。。。。。。。。。。3  ");
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}

