package com.dongzhic.java.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 增强类：对目标对象的方法增强
 * @Author dongzhic
 * @Date 7/12/21 11:10 AM
 */
public class Parent implements InvocationHandler {

    private People people;

    public Parent(People people) {
        this.people = people;
    }

    /**
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 调用XiaoMing类中的ZhaoDuiXiang()方法
        method.invoke(people, args);

        return null;
    }

}
