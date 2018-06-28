package com.dongzhic.design.patterns.proxy.demo2;

/**
 * @author dongzc
 * @date 2018/6/27 18:12
 */
public class Client {

    public static void main(String[] args) {
        Car car = new Car();
        CarTimeProxy timeProxy = new CarTimeProxy(car);
        CarLogProxy logProxy = new CarLogProxy(timeProxy);
        logProxy.move();
    }
}
