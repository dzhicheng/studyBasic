package com.dongzhic.java.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 对TargetClass.add()方法的拦截
 * @Author dongzhic
 * @Date 7/12/21 4:19 PM
 */
public class AddInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("AddInterceptor.intercept before");
        methodProxy.invokeSuper(o, objects);
        System.out.println("AddInterceptor.intercept after");
        return null;
    }
}
