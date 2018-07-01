package com.dongzhic.design.patterns.proxy.cglibproxy.demo1;

/**
 * @author dongzc
 * @date 2018/6/29 15:00
 */
public class Main {

    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        Train train = (Train) proxy.getProxy(Train.class);
        train.move();
    }
}
