package com.dongzhic.java.thread;

import com.dongzhic.datastructures.List;
import com.dongzhic.datastructures.array.ArrayList;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 实现一个容器，提供两个方法，add，size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数为5的时候，线程2给出提示并结束
 * @Author dongzhic
 * @Date 3/10/21 3   :29 PM
 */
public class Demo01 {

    private List list = new ArrayList();

    private static Thread t1 = null;
    private static Thread t2 = null;

    public  void add (Object obj) {
        list.add(obj);
    }

    public int size () {
        return list.size();
    }

    public static void main(String[] args) {

        Demo01 lock = new Demo01();

        way3(lock);

    }

    /**
     * 使用synchronized,wait,notify
     * @param lock
     */
    public static void way1 (Demo01 lock) {
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2 启动");
                if (lock.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 结束");
                lock.notify();
            }
        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t1 启动");
                for (int i = 0; i < 10; i++) {
                    lock.add(new Object());
                    System.out.println("add " + i);

                    if (lock.size() == 5) {
                        lock.notify();

                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

                System.out.println("t1 结束");
            }
        }, "t1").start();
    }

    /**
     * 使用CountDownLatch门栓
     * @param lock
     */
    public static void way2 (Demo01 lock) {

        CountDownLatch latch1 = new CountDownLatch(1);
        CountDownLatch latch2 = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("t2 启动");
            if (lock.size() != 5) {
                try {
                    latch2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 结束");
            latch1.countDown();
        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            System.out.println("t1 启动");
            for (int i = 0; i < 10; i++) {
                lock.add(new Object());
                System.out.println("add " + i);

                if (lock.size() == 5) {
                    try {
                        latch2.countDown();
                        latch1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            System.out.println("t1 结束");
        }, "t1").start();
    }

    /**
     * 使用LockSupport
     * @param lock
     */
    public static void way3 (Demo01 lock) {

        t1 = new Thread( ()-> {
            System.out.println("t1 启动");
            for (int i = 0; i < 10; i ++) {
                lock.add(new Object());
                System.out.println("add " + i);
                if (lock.size() == 5) {
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
            System.out.println("t1 结束");
        }, "t1");

        t2 = new Thread( ()-> {
            System.out.println("t2 启动");
            LockSupport.park();
            System.out.println("t2 结束");
            LockSupport.unpark(t1);
        }, "t2");

        t1.start();
        t2.start();

    }
}
