package com.dongzhic.design.patterns.singleton;

/**
 *  懒汉模式1.1，线程不安全
 *      使用synchronized关键字双重检查
 * @author dongzc
 * @date ${date} ${time}
 */
public class SingletonPattern1b {

    /**
     * 私有构造函数
     */
    private SingletonPattern1b() {}

    /**
     * 私有成员保存实例
     */
    private static SingletonPattern1b instance = null;

    /**
     * 通过静态方式形成实例，使其他类不能通过new方式形成实例
     *  1.如果实例创建，不需要同步，直接返回
     *  2.同步线程
     *  3.同步线程中，如果一个线程创建了对象，其他线程不需要创建
     * @return
     */
    public static SingletonPattern1b getInstance () {
        if (instance == null) {
            synchronized (SingletonPattern1b.class) {
                if (instance == null) {
                    instance = new SingletonPattern1b();
                }
            }
        }
        return instance;
    }

}
