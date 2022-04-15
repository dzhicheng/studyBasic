package com.dongzhic.java.reflect.proxy;

/**
 * @Author dongzhic
 * @Date 2021/12/7 17:04
 */
public class StaticProxyTest {

    public static void main(String[] args) {

        IUserDao target = new UserDao();

        UserDaoProxy proxy = new UserDaoProxy(target);
        proxy.save();


    }
}