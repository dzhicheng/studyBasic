package com.dongzhic.java.thread;

import com.dongzhic.datastructures.link.LinkedList;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 写一个固定容量同步容器，拥有put和get方法，以及getCount方法
 * 能支持2个生产者线程以及10个消费者线程的阻塞调用
 * @Author dongzhic
 * @Date 3/10/21 6:18 PM
 */
public class Demo04 {

    private final LinkedList<Object> list = new LinkedList<>();
    private final static int MAX_SIZE = 10;
    private int count = 0;

    Lock lock = new ReentrantLock();
    // 生产者等待队列
    private Condition producer = lock.newCondition();
    // 消费者等待队列
    private Condition consumer = lock.newCondition();

    public void put (Object obj) {
        try {
            lock.lock();
            while (list.size() >= MAX_SIZE) {
                consumer.await();
            }
            list.add(obj);
            ++count;
            // 通知消费者进行消费
            producer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public  Object get () {
        Object result = null;
        try {
            lock.lock();
            while (list.size() == 0) {
                consumer.await();
            }
            result = list.remove(0);
            count--;
            // 通知生产 者进行生产
            producer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return result;
    }
}
