package com.dongzhic.java.thread.topic;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 交替打印问题
 *  1A2B3C4D
 *  一个线程打印ABCDE，另一个线程打印12345
 * @Author dongzhic
 * @Date 2021/11/16 15:05
 */
public class Demo02 {

    public static void main(String[] args) {

        List<String> list1 = Arrays.asList("A", "B", "C", "D", "E");
        List<String> list2 = Arrays.asList("1", "2", "3", "4", "5");

        way02(list1, list2);
    }

    /**
     * 使用ReentrantLock
     * @param list1
     * @param list2
     */
    public static void way01 (List<String> list1, List<String> list2) {

        Lock lock = new ReentrantLock();
        // 控制字母的锁
        Condition c1 = lock.newCondition();
        // 控制数字的锁
        Condition c2 = lock.newCondition();

        Thread t1 = new Thread(() -> {
            try {
                 lock.lock();
                for (int i = 0; i < list1.size(); i++) {
                    System.out.println(list1.get(i));

                    c2.signal();
                    c1.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "打印字母的线程");

        Thread t2 = new Thread(() -> {
            try {
                lock.lock();
                for (int j = 0; j < list2.size(); j++) {
                    System.out.println(list2.get(j));

                    c1.signal();
                    c2.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "打印数字的线程");


        t1.start();
        t2.start();
    }

    public static void way02 (List<String> list1, List<String> list2) {
        Demo02 lock = new Demo02();

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < list1.size(); i++) {
                    System.out.println(list1.get(i));

                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                lock.notify();
            }
        }, "打印字母的线程");

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                for (int j = 0; j < list2.size(); j++) {
                    System.out.println(list2.get(j));
                    lock.notify();

                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }, "打印数字的线程");

        t2.start();
        t1.start();
    }


}
