package com.dongzhic.design.patterns.proxy.demo2;

import com.dongzhic.design.patterns.proxy.demo1.Moveable;

import java.util.Random;

/**
 * @author dongzc
 * @date 2018/6/27 17:05
 */
public class Car implements Moveable {

    public void move() {
        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("汽车行驶中...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
