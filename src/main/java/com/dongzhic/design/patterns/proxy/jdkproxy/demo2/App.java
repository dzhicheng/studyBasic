package com.dongzhic.design.patterns.proxy.jdkproxy.demo2;

/**
 * @author dongzc
 * @date 2018/7/3 10:44
 */
public class App {

    public static void main(String[] args) {

        //目标对象
        IUserDao userDao = new UserDao();
        System.out.println(userDao.getClass());

        //给目标对象创建代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(userDao).getProxyInstance();
        proxy.save();
    }
}
