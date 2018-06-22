package com.dongzhic.design.patterns.singleton;

/**
 *  懒汉模式1.2，volatile 关键字,线程安全
 *      1.被修饰的变量不会在多线程中存在副本，直接从内存读取。
 *      2.禁止指令重排序优化
 * @author dongzc
 * @date ${date} ${time}
 */
public class SingletonPattern1c {

    /**
     * 私有构造函数
     */
    private SingletonPattern1c() {}

    /**
     * 私有成员保存实例
     */
    private volatile static SingletonPattern1c instance = null;

    /**
     * 通过静态方式形成实例，使其他类不能通过new方式形成实例
     *  1.如果实例创建，不需要同步，直接返回
     *  2.同步线程
     *  3.同步线程中，如果一个线程创建了对象，其他线程不需要创建
     * @return
     */
    public static SingletonPattern1c getInstance () {
        if (instance == null) {
            synchronized (SingletonPattern1c.class) {
                if (instance == null) {
                    //不加volatile关键字，可能会出现指令重排序优化，
                    //会出现执行顺序：1-2-3或1-3-2
                    instance = new SingletonPattern1c();
                    //JVM大概做了3件事情
                    //1.給singleton分配内存
                    //2.调用SingletonPattern1c的构造函数来初始化成员变量，形成实例
                    //3.将singleton对象指向分配的内存空间（此时singleton才是非null）
                }
            }
        }
        return instance;
    }

}
