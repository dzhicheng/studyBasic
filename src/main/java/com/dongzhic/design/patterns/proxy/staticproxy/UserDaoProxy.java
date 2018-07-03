package com.dongzhic.design.patterns.proxy.staticproxy;

/**
 * 代理对象：静态代理
 * @author dongzc
 * @date 2018/7/3 10:05
 */
public class UserDaoProxy implements IUserDao {

    private UserDao target;

    public UserDaoProxy(UserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("==============开始事务==============");
        target.save();//执行目标对象的方法
        System.out.println("==============开始事务==============");
    }
}
