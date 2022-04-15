package com.dongzhic.java.thread.topic;

import com.dongzhic.Demo;
import com.dongzhic.datastructures.List;
import com.dongzhic.datastructures.array.ArrayList;
import com.dongzhic.java.generics.A;

import java.util.concurrent.CountDownLatch;

/**
 * 实现一种容器，提供两种方法，add，size
 * 写两个线程，线程1添加10个元素到容器，线程2监控元素个数，
 * 当size=5时，线程2提示并退出
 * @Author dongzhic
 * @Date 2021/11/16 14:31
 */
public class Demo01 {

    List list = new ArrayList();

    public void add (Object obj) {
        list.add(obj);
    }

    public int size () {
        return list.size();
    }

    public static void main(String[] args) {
        Demo01 demo = new Demo01();
        demo.way01(demo);
    }

    /**
     * 使用synchronized, wait,notify
     * wait释放锁
     */
    public void way01 (Demo01 lock) {

        new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + ", 启动");
                for (int i = 0; i < 10; i++) {
                    lock.add(new Object());
                    System.out.println("add, " + i);

                    if (lock.size() == 5) {
                        lock.notify();

                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println(Thread.currentThread().getName() + ", 结束");
            }
        }, "线程1").start();

        new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + ", 启动");
                if (lock.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
                System.out.println(Thread.currentThread().getName() + ", 结束");
            }
        }, "线程2").start();

    }

    /**
     * 使用CountDownLatch
     */
    public void way02 (Demo01 lock) {

        CountDownLatch latch1 = new CountDownLatch(1);
        CountDownLatch latch2 = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "，启动");
            for (int i = 0; i < 10; i++) {
                lock.add(new Object());
                System.out.println(Thread.currentThread().getName() + ", i");

                if (lock.size() == 5) {
                    latch2.countDown();
                    try {
                        latch1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(Thread.currentThread().getName() + "，结束");
        }, "线程1").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "，启动");
            if (lock.size() != 5) {
                try {
                    latch2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "，结束");
            latch1.countDown();
        }, "线程2").start();
    }


}
