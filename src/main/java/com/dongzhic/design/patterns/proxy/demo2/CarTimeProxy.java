package com.dongzhic.design.patterns.proxy.demo2;

import com.dongzhic.design.patterns.proxy.demo1.Car;
import com.dongzhic.design.patterns.proxy.demo1.Moveable;

/**
 * 通过聚合的方式实现代理
 * @author dongzc
 * @date 2018/6/27 17:20
 */
public class CarTimeProxy implements Moveable{

    private Moveable moveable;

    public CarTimeProxy(Moveable moveable) {
        this.moveable = moveable;
    }

    public void move() {
        long startTime = System.currentTimeMillis();
        System.out.println("汽车开始行驶....");
        moveable.move();
        long endTime = System.currentTimeMillis();
        System.out.println("汽车结束行驶....，汽车行驶时间为："+
                (endTime - startTime) +"毫秒");
    }
}
