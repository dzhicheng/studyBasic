package com.dongzhic.java.reflect.jdk;

/**
 * @Author dongzhic
 * @Date 2021/12/8 10:29
 */
public class JdkProxyTest {

    public static void main(String[] args) {

        IUserDao target = new UserDao();
        // 输出目标对象信息
        System.out.println(target.getClass());

        IUserDao proxy = (IUserDao) new UserProxyFactory(target).getProxyInstance();
        // 输出代理对象信息
        System.out.println(proxy.getClass());
        // 执行代理方法
        proxy.save();

    }
}
