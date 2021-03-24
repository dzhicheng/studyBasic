package com.dongzhic.design.patterns.proxy.cglibproxy.demo2;

/**
 * 代理模式
 * @author dongzc
 * @date 2018/7/3 12:12
 */
public class App {

    public static void main(String[] args) {
        //目标对象
        UserDao userDao = new UserDao();

        //代理对象
        UserDao proxyUserDao = (UserDao) new ProxyFactory(userDao).getProxyInstance();

        //执行代理对象方法
        proxyUserDao.save();
    }
}
