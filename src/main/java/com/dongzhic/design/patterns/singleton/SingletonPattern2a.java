package com.dongzhic.design.patterns.singleton;

/**
 * 饿汉模式2.0，线程安全
 * @author dongzc
 * @date 2018/6/20 17:02
 */
public class SingletonPattern2a {

    private SingletonPattern2a() {}

    private static final SingletonPattern2a instance = new SingletonPattern2a();

    public static SingletonPattern2a getInstance () {
        return instance;
    }

}
