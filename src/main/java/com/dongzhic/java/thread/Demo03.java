package com.dongzhic.java.thread;

import com.dongzhic.datastructures.link.LinkedList;

import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 写一个固定容量同步容器，拥有put和get方法，以及getCount方法
 * 能支持2个生产者线程以及10个消费者线程的阻塞调用
 * @Author dongzhic
 * @Date 3/10/21 6:18 PM
 */
public class Demo03 {

    private final LinkedList<Object> list = new LinkedList<>();
    private final static int MAX_SIZE = 10;
    private int count = 0;

    public synchronized void put (Object obj) {

//        Executor

        while (list.size() >= MAX_SIZE) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        list.add(obj);
        ++count;
        // 通知消费者进行消费
        this.notifyAll();
    }

    public synchronized Object get () {
        Object result = null;
        while (list.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        result = list.remove(0);
        count--;
        // 通知生产 者进行生产
        this.notifyAll();

        return result;
    }
}
