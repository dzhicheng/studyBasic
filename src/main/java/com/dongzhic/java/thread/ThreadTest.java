package com.dongzhic.java.thread;

/**
 * @Author dongzhic
 * @Date 3/5/21 12:56 PM
 */
public class ThreadTest {

    private static boolean initFlag = false;



    public static void main(String[] args) {

        new Thread( () -> {
            System.out.println("waiting data ......");
            while (!initFlag) {

            }
            System.out.println("=====================success");
        }, "t1").start();

        new Thread( () -> {
            prepareData();
        }, "t2").start();
    }

    public static void prepareData () {
        System.out.println("prepare data ......");
        initFlag = true;
        System.out.println("prepare data end ......");
    }


}
