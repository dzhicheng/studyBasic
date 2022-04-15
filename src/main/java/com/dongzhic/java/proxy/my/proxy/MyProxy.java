package com.dongzhic.java.proxy.my.proxy;

import java.lang.reflect.InvocationHandler;

/**
 * @Author dongzhic
 * @Date 7/12/21 4:48 PM
 */
public class MyProxy {

    /**
     * 换行
     */
    private static String rt = "\r\n";

    public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          MyInvocationHandler h) {

        // 1.以字符串的形式拼凑出一个代理类

        // 2.以流的方式写入java文件

        // 3.java文件动态编译成.class文件

        // 4.自定义类类加载器，把磁盘里面的.class文件加载到内存

        // 5.实例化内存里面的类，并返回实例

        return null;
    }
}
