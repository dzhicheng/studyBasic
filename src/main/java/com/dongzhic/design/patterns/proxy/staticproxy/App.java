package com.dongzhic.design.patterns.proxy.staticproxy;

import java.lang.reflect.Proxy;

/**
 * 测试类
 * @author dongzc
 * @date 2018/7/3 10:02
 */
public class App {

    public static void main(String[] args) {
        //目标对象
        UserDao userDao = new UserDao();
        //代理对象，把目标对象传给代理对象，建立代理关系
        UserDaoProxy daoProxy = new UserDaoProxy(userDao);
        //执行代理对象方法
        daoProxy.save();
    }
}
