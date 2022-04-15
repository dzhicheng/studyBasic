package com.dongzhic.java.thread.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author dongzhic
 * @Date 2021/9/29 14:42
 */
public class AtomicStampedReferenceTest {

    private static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(1, 0);

    public static void main(String[] args) {

        Thread main = new Thread(() -> {

            // 获取当前标识
            int stamp = atomicStampedReference.getStamp();
        }, "主线程");

        Thread other = new Thread(() -> {

        }, "干扰线程");
    }
}
