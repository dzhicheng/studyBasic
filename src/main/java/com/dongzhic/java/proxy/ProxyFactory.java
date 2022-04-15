package com.dongzhic.java.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理类
 * @Author dongzhic
 * @Date 6/17/21 6:41 PM
 */
public class ProxyFactory implements MethodInterceptor {

    /**
     * 维护目标对象
     */
    private Object targe;

    public ProxyFactory (Object targe) {
        this.targe = targe;
    }

    /**
     * 给目标对象创建代理类
     * @return
     */
    public Object getProxyInstance () {
        // 1.工具类
        Enhancer en = new Enhancer();
        // 2.设置父类
        en.setSuperclass(targe.getClass());
        // 3.设置回调函数
        en.setCallback(this);
        // 4.创建子类(代理对象)
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("开始事务.............");

        // 执行目标对象的方法
        Object returnValue = method.invoke(targe, objects);

        System.out.println("提交事务.............");
        return null;
    }
}
