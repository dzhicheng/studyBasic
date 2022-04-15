package com.dongzhic.java.reflect.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author dongzhic
 * @Date 2021/12/8 10:21
 */
public class UserProxyFactory{

    /**
     * 维护一个目标对象
     */
    private Object target;

    public UserProxyFactory (Object target) {
        this.target = target;
    }

    /**
     * 为目标对象生产代理对象
     * @return
     */
    public Object getProxyInstance () {

        // Lambda写法
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("开启事务.....");
                    // 执行目标对象方法
                    Object returnValue = method.invoke(target, args);
                    System.out.println("提交事务.....");
                    return null;
                });

        // 标准写法
//        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
//                new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//
//                        System.out.println("开启事务.....");
//                        // 执行目标对象方法
//                        Object returnValue = method.invoke(target, args);
//                        System.out.println("提交事务.....");
//                        return null;
//                    }
//                });
    }

}
