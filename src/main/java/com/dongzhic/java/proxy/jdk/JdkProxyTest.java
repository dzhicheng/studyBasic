package com.dongzhic.java.proxy.jdk;


import sun.misc.ProxyGenerator;

import java.lang.reflect.Proxy;

/**
 * @Author dongzhic
 * @Date 7/12/21 11:13 AM
 */
public class JdkProxyTest {

    public static void main(String[] args) {

        // ClassLoader loader 类加载器
        // Class<?>[] interfaces 反射对象(被代理类实现接口)
        // InvocationHandler h

        // proxy是小明的一个代理对象，小明是被代理对象
        People proxy = (People) Proxy.newProxyInstance(JdkProxyTest.class.getClassLoader(), new Class<?>[] {People.class},
                new Parent(new XiaoMing()));

        proxy.ZhaoDuiXiang();
    }

    public static void createProxyClassFile () {
        // 获取字节码文件
        ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{People.class});
    }
}
