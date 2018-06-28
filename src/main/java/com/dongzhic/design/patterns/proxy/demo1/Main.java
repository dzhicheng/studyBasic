package com.dongzhic.design.patterns.proxy.demo1;

/**
 * @author dongzc
 * @date 2018/6/27 17:14
 */
public class Main {
    public static void main(String[] args) {
        Moveable car = new Car2(new Car());
        car.move();
    }
}
