package com.dongzhic.java.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 交替打印ABC
 * @Author dongzhic
 * @Date 2021/12/15 09:42
 */
public class ABCABC {

    public static void main(String[] args) {
        way2();

        new ThreadLocal<>();
    }

    /**
     * 使用Lock + Condition
     */
    public static void way1 () {

        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.print("A");
                    conditionB.signal();
                    conditionA.await();
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "打印B线程");

        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.print("B");
                    conditionC.signal();
                    conditionB.await();
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "打印A线程");

        Thread t3 = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("C");
                    conditionA.signal();
                    conditionC.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "打印C线程");

        t1.start();
        t2.start();
        t3.start();

    }

    /**
     * 方法二：
     */
    public static Thread t1;
    public static  Thread t2;
    public static  Thread t3;
    public static void way2 () {

        try {
            t1 = new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    System.out.print("A");
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }, "打印A线程");

            t2 = new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    System.out.print("B");
                    LockSupport.unpark(t3);
                    LockSupport.park();
                }
            }, "打印B线程");

//            t3 = new Thread(() -> {
//                for (int i = 0; i < 5; i++) {
//                    System.out.println("C");
//                    LockSupport.unpark(t1);
//                    LockSupport.park();
//                }
//            }, "打印C线程");
        } catch (Exception e) {
            e.printStackTrace();
        }

        t1.start();
        t2.start();
//        t3.start();
    }



}
