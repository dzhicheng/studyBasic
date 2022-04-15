package com.dongzhic.leetcode;

/**
 * @Author dongzhic
 * @Date 2021/10/17 22:21
 */
public class Singleton {

    private volatile static Singleton instance;

    private Singleton () {}

    public Singleton getInstance () {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
