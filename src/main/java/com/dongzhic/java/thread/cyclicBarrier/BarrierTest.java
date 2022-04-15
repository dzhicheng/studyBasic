package com.dongzhic.java.thread.cyclicBarrier;

import java.util.concurrent.*;

/**
 * @Author dongzhic
 * @Date 6/3/21 5:37 PM
 */
public class BarrierTest {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);
        Runner runner1 = new Runner("张三", barrier);
        Runner runner2 = new Runner("李四", barrier);
        Runner runner3 = new Runner("王五", barrier);

        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(runner1);
        service.execute(runner2);
        service.execute(runner3);

        service.shutdown();
    }

}

class Runner implements Runnable {

    private String name;
    private CyclicBarrier cyclicBarrier;

    public Runner(String name, CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {

        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(name + "准备ok");
            cyclicBarrier.await();
            System.out.println(name + "开跑");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
