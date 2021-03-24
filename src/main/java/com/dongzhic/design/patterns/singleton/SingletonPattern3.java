package com.dongzhic.design.patterns.singleton;

/**
 * 不仅解决线程同步，还可以防止反序列化
 * @Author dongzhic
 * @Date 3/20/21 2:03 AM
 */
public enum  SingletonPattern3 {
    INSTANCE;

    public void m () {}

}
