package com.dongzhic.design.patterns.singleton;

/**
 * 饿汉模式2.1，线程安全
 *  使用JVM本身的机制保证线程安全
 * @author dongzc
 * @date 2018/6/20 17:02
 */
public class SingletonPattern2b {

    private SingletonPattern2b() {}

    private static class SingletonHolder {
        private static final SingletonPattern2b INSTANCE = new SingletonPattern2b();
    }
    public static SingletonPattern2b getInstance () {
        return SingletonHolder.INSTANCE;
    }

}
