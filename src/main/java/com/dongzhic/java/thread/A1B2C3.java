package com.dongzhic.java.thread;

import com.dongzhic.datastructures.List;
import com.dongzhic.datastructures.array.ArrayList;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1A2B3C问题
 * 一个线程打印ABCDE，另一个线程打印12345，两个线程交替输出
 * @Author dongzhic
 * @Date 3/10/21 4:17 PM
 */
public class A1B2C3 {

    private static Thread t1 = null, t2 = null;

    private static CountDownLatch latch1 = new CountDownLatch(1);
    private static CountDownLatch latch2 = new CountDownLatch(1);

    public static void main(String[] args) {

        List<String> list1 = new ArrayList<String>(){{
            add("A");
            add("B");
            add("C");
            add("D");
            add("E");
        }};
        List<String> list2 = new ArrayList<String>(){{
            add("1");
            add("2");
            add("3");
            add("4");
            add("5");
        }};

        way2(list1, list2);
    }

    /**
     * 使用synchronized wait notify
     * @param list1
     * @param list2
     */
    public static void way1 (List<String> list1, List<String> list2) {
        A1B2C3 lock = new A1B2C3();

        t1 = new Thread( () -> {
            synchronized (lock) {
                for (int i = 0;i < list1.size(); i ++) {
                    System.out.println(list1.get(i));
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                // 必须，否则无法停止程序
                lock.notify();
            }
        }, "t1");

        t2 = new Thread( () -> {
            synchronized (lock) {
                for (int i = 0;i < list2.size(); i ++) {
                    System.out.println(list2.get(i));
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                lock.notify();
            }
        }, "t2");

        t1.start();
        t2.start();
    }

    /**
     * 使用 LockSupport
     * @param list1
     * @param list2
     */
    public static void way2 (List<String> list1, List<String> list2) {

        t1 = new Thread( () -> {

            for (int i = 0;i < list1.size(); i ++) {
                System.out.println(list1.get(i));
                LockSupport.park();
                LockSupport.unpark(t2);
            }
        }, "t1");

        t2 = new Thread( () -> {

            for (int j = 0;j < list2.size(); j ++) {
                System.out.println(list2.get(j));
                LockSupport.unpark(t1);
                LockSupport.park();
            }
        }, "t2");

        t1.start();
        t2.start();
    }

    /**
     * 使用ReentrantLock
     * @param list1
     * @param list2
     */
    public static void way3 (List<String> list1, List<String> list2) {

        Lock lock = new ReentrantLock();
        // 控制字母的锁
        Condition c1 = lock.newCondition();
        // 控制数字的锁
        Condition c2 = lock.newCondition();

        new Thread( () -> {
            try {
                lock.lock();
                for (int i = 0;i < list1.size(); i ++) {
                    System.out.println(list1.get(i));
                    c2.signal();
                    c1.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1");

        new Thread( () -> {
            try {
                lock.lock();
                for (int j = 0; j < list2.size(); j ++) {
                    System.out.println(list2.get(j));
                    c1.signal();
                    c2.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2");




    }




}
