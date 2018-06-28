package com.dongzhic.design.patterns.proxy.demo2;

import com.dongzhic.design.patterns.proxy.demo1.Moveable;

/**
 * 通过聚合的方式实现代理
 * @author dongzc
 * @date 2018/6/27 17:20
 */
public class CarLogProxy implements Moveable{

    private Moveable moveable;

    public CarLogProxy(Moveable moveable) {
        this.moveable = moveable;
    }

    public void move() {
        System.out.println("日志开始....");
        moveable.move();
        System.out.println("日志结束....");
    }
}
