package com.dongzhic.design.patterns.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author dongzc
 * @date 2018/6/28 17:01
 */
public class TimeHandler implements InvocationHandler {

    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    /**
     * @param proxy 被代理的对象
     * @param method 被代理对象的方法
     * @param args 被代理对象方法的参数
     * @return 方法的返回值
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("汽车开始行驶....");
        method.invoke(target);
        long endTime = System.currentTimeMillis();
        System.out.println("汽车结束行驶....，汽车行驶时间为："+
                (endTime - startTime) +"毫秒");
        return null;
    }
}
