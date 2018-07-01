package com.dongzhic.design.patterns.proxy.demo3;

/**
 * 真实对象类
 * @author dongzc
 * @date 2018/6/29 19:11
 */
public class RealSubject implements Subject {
    public void buyMac() {
        System.out.println("买一台Mac");
    }
}
