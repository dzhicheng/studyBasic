package com.dongzhic.java.thread;

import java.sql.PseudoColumnUsage;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Author dongzhic
 * @Date 3/11/21 11:17 AM
 */
public class ThreadLocalTest {

    public static void main(String[] args) {

//        Thread
//        ThreadLocal

        Person p = new Person();
        p.setName("zhangsan");

        new Thread( ()-> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(p.getName());
        }, "t1").start();

        new Thread( ()-> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.setName("lisi");
        }, "t2").start();


    }
}


class Person {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

