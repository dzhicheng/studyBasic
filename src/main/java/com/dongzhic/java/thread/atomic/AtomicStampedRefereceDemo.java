package com.dongzhic.java.thread.atomic;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 解决aba问题
 * @Author dongzhic
 * @Date 5/15/21 10:24 AM
 */
public class AtomicStampedRefereceDemo {

    private static AtomicStampedReference<Integer> atomicStampedReference =
            new AtomicStampedReference<>(1, 0);

    public static void main(String[] args) {

        Thread main = new Thread(() -> {
            // 获取当前标识
            int stamp = atomicStampedReference.getStamp();
            System.out.println("操作线程" + Thread.currentThread().getName() + "stamp="
                    + stamp + ", 初始值 a = " + atomicStampedReference.getReference());

            try {
                // 等待3秒，让其他线程先执行
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean isCASSuccess = atomicStampedReference.compareAndSet(1,
                    2, stamp, stamp+1);
            System.out.println("操作线程" + Thread.currentThread().getName() + "stamp="
                    + stamp + ", CAS操作结果: " + isCASSuccess);
        }, "主线程");

        Thread other = new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            atomicStampedReference.compareAndSet(1,
                    2, stamp, stamp + 1);
            System.out.println("操作线程" + Thread.currentThread().getName() + "stamp="
                    + stamp + ", 【increment】, 值 a =" + atomicStampedReference.getReference());
            stamp = atomicStampedReference.getStamp();
            atomicStampedReference.compareAndSet(2, 1, stamp, stamp+1);
            System.out.println("操作线程" + Thread.currentThread().getName() + "stamp="
                    + stamp + ", 【increment】, 值 a =" + atomicStampedReference.getReference());
        }, "干扰线程");

        main.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        other.start();
    }


}
