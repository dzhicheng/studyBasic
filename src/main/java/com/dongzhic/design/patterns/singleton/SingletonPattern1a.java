package com.dongzhic.design.patterns.singleton;

/**
 *  懒汉模式1.0，线程不安全
 *      多线程环境下，多个线程同时调用getInstance方法
 *      同时通过(instance == null)的校验，创建多个实例，
 *      就会存在内存泄漏的问题
 * @author dongzc
 * @date ${date} ${time}
 */
public class SingletonPattern1a {

    /**
     * 私有构造函数
     */
    private SingletonPattern1a() {}

    /**
     * 静态私有成员保存实例
     */
    private static SingletonPattern1a instance = null;

    /**
     *  共有的静态方法:
     * 通过共有静态方式形成实例，使其他类不能通过new方式形成实例
     * @return
     */
    public static SingletonPattern1a getInstance () {
        if (instance == null) {
            instance = new SingletonPattern1a();
        }
        return instance;
    }

}
