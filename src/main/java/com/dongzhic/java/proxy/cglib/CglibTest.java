package com.dongzhic.java.proxy.cglib;

/**
 * @Author dongzhic
 * @Date 7/12/21 4:30 PM
 */
public class CglibTest {

    public static void main(String[] args) {

        // 目标类
        TargetClass targetClass = (TargetClass) CglibInstanceFactory.getInstance();
        targetClass.del();
    }
}
