package com.dongzhic.java.thread.countDownLatch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author dongzhic
 * @Date 6/3/21 5:24 PM
 */
public class CountDownTest {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(2);
        Worker worker1 = new Worker("张三", 1, latch);
        Worker worker2 = new Worker("李四", 1, latch);
        worker1.start();
        worker2.start();

        try {
            long startTime = System.currentTimeMillis();
            latch.await();
            System.out.println("bug全部解决，领导可以给客户交差了，任务总耗时："+ (System.currentTimeMillis() - startTime));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class Worker extends Thread {

        String name;
        int workTime;
        CountDownLatch latch;

        public Worker (String name, int workTime, CountDownLatch latch) {
            this.name = name;
            this.workTime = workTime;
            this.latch = latch;
        }

        @Override
        public void run () {
            System.out.println(name + "开始修复bug 当前时间：" + sdf.format(new Date()));
            doWork();
            System.out.println(name + "结束修复bug，当前时间：" + sdf.format(new Date()));
            latch.countDown();
        }

        private void doWork () {

            try {
                // 模拟工作耗时
                TimeUnit.SECONDS.sleep(workTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
