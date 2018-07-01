package com.dongzhic.design.patterns.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author dongzc
 * @date 2018/6/29 13:41
 */
public class Main {

    public static void main(String[] args) {

        Car car = new Car();
        InvocationHandler timeHandler = new TimeHandler(car);
        Class<?> c = car.getClass();

        /**
         * 时间处理器
         * loader 类加载器
         * interfaces 实现接口
         * h 事件处理器InvocationHandler
         */
        Moveable m = (Moveable) Proxy.newProxyInstance(c.getClassLoader(), c.getInterfaces(), timeHandler);

        //日志处理器
        InvocationHandler logHandler = new LogHandler(m);
        Moveable m1 = (Moveable) Proxy.newProxyInstance(c.getClassLoader(), c.getInterfaces(), logHandler);

        m1.move();
    }
}
