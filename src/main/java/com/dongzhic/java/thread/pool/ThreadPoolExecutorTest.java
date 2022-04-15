package com.dongzhic.java.thread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 线程池测试类
 * @Author dongzhic
 * @Date 2021/10/9 11:13
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 5, 20, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5));

        String errorMsg = "";
        try {
            List<Future<Integer>> resultList = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                Future<Integer> future = executor.submit(new IntegerSquare(i));
                resultList.add(future);
            }

            System.out.println("==============================================");
            for (Future<Integer> future : resultList) {
                System.out.println(future.get());
            }
            System.out.println("==============================================");
        } catch (Exception e) {
            errorMsg = e.getMessage();
            e.printStackTrace();
        }


        System.out.println("返回用户错误信息" + errorMsg);
    }


}

/**
 * 用于计算并返回输入的整数的平方
 */
class IntegerSquare implements Callable<Integer> {

    /**
     * 进行平方运算的数
     */
    private Integer num;

    public IntegerSquare () {}
    public IntegerSquare(Integer num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {

//        try {
            System.out.println(Thread.currentThread().getName() + " ：" +num);
            if (num == 3) {
                throw new NullPointerException();
            }
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        }

        return num;
    }
}

