package com.dongzhic.java.thread;

import com.dongzhic.java.thread.source.ReentrantLock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author dongzhic
 * @Date 5/13/21 12:08 PM
 */
public class SemaphoreDemo {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        lock.lock();

        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 10; i ++) {
            new Thread(new Task(semaphore, "yangguo" + i)).start();
        }

    }


    static class Task extends Thread{
        Semaphore semaphore;

        public Task (Semaphore semaphore, String tName) {
            super(tName);
            this.semaphore = semaphore;
        }

        public void run () {
            try {
                // 获取公共资源
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + ": acquire() at time:" + System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 释放公共资源
                semaphore.release();
            }


        }
    }
}
