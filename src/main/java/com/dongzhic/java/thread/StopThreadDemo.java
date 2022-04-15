package com.dongzhic.java.thread;

/**
 * 终止线程
 * @Author dongzhic
 * @Date 2021/10/25 15:04
 */
public class StopThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        MyThread m1 = new MyThread();
        System.out.println("Starting thread...");
        m1.start();
        Thread.sleep(3000);
        System.out.println("Interrupt thread...: " + m1.getName());
        m1.stop = true;
        // 设置共享变量为true
        m1.interrupt();
        // 阻塞时退出阻塞状态
        Thread.sleep(3000);
        // 主线程休眠3秒以便观察线程m1的中断情况
        System.out.println("Stopping application...");
    }
}

class MyThread extends Thread {

    volatile boolean stop = false;

    @Override
    public void run() {
        System.out.println(getName() + " is running");
        while (!stop) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("week up from blcok...");
                // 在异常处理代码中修改共享变量的状态
                stop = true;
            }
        }
        System.out.println(getName() + " is exiting...");
    }
}
