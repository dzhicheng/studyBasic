package com.dongzhic.java.proxy.cglib;

/**
 * @Author dongzhic
 * @Date 7/12/21 4:00 PM
 */
public class TargetClass {

    public void add () {
        System.out.println("TargetClass.add");
    }

    /**
     * 开启事务
     */
    public void del () {
        System.out.println("TargetClass.del");
    }

    /**
     * 增强缓存
     */
    public void query () {
        System.out.println("TargetClass.query");
    }
}
