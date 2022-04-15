package com.dongzhic.java.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 对TargetClass.query()方法的拦截
 * @Author dongzhic
 * @Date 7/12/21 4:21 PM
 */
public class QueryInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("QueryInterceptor.intercept before");
        methodProxy.invokeSuper(o, objects);
        System.out.println("QueryInterceptor.intercept after");
        return null;
    }
}
