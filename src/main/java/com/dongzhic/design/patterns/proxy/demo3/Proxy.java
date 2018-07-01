package com.dongzhic.design.patterns.proxy.demo3;

/**
 * 代理对象类
 * @author dongzc
 * @date 2018/6/29 19:13
 */
public class Proxy implements Subject {
    public void buyMac() {

        //引用并创建真实对象的实例
        RealSubject realSubject = new RealSubject();
        realSubject.buyMac();
        this.WrapMac();

    }

    public void WrapMac() {
        System.out.println("用盒子包装好Mac");
    }
}
