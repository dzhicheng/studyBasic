package com.dongzhic.design.patterns.proxy.demo1;

/**
 * 通过继承的方式实现静态代理
 * @author dongzc
 * @date 2018/6/27 17:16
 */
public class Car1 extends Car {
    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        System.out.println("汽车开始行驶....");
        super.move();
        long endTime = System.currentTimeMillis();
        System.out.println("汽车结束行驶....，汽车行驶时间为："+
                (endTime - startTime) +"毫秒");
    }
}
