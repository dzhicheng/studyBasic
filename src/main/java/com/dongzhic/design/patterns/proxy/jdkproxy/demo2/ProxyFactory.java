package com.dongzhic.design.patterns.proxy.jdkproxy.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author dongzc
 * @date 2018/7/3 10:39
 */
public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance (){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("=================开始事务=================");
                        //执行目标对象的方法
                        Object returnValue = method.invoke(target, args);
                        System.out.println("=================结束事务=================");
                        return returnValue;
                    }
                });
    }
}
