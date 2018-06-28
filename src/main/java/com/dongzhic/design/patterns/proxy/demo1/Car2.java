package com.dongzhic.design.patterns.proxy.demo1;

/**
 * 通过聚合的方式实现代理
 * @author dongzc
 * @date 2018/6/27 17:20
 */
public class Car2 implements Moveable{

    private Car car;

    public Car2(Car car) {
        this.car = car;
    }

    public void move() {
        long startTime = System.currentTimeMillis();
        System.out.println("汽车开始行驶....");
        car.move();
        long endTime = System.currentTimeMillis();
        System.out.println("汽车结束行驶....，汽车行驶时间为："+
                (endTime - startTime) +"毫秒");
    }
}
