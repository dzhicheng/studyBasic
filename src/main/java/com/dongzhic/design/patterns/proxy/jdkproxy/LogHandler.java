package com.dongzhic.design.patterns.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author dongzc
 * @date 2018/6/29 14:01
 */
public class LogHandler implements InvocationHandler {

    private Object target;

    public LogHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("日志开始....");
        method.invoke(target);
        System.out.println("日志结束....");
        return null;
    }
}
