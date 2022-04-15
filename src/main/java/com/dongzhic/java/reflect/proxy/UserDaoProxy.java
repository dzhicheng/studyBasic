package com.dongzhic.java.reflect.proxy;

/**
 * @Author dongzhic
 * @Date 2021/12/7 17:00
 */
public class UserDaoProxy implements IUserDao{

    private IUserDao target;

    public UserDaoProxy (IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开启事务.....");
        target.save();
        System.out.println("提交事务.....");
    }
}
