package com.dongzhic.java.reflect.proxy;

/**
 * @Author dongzhic
 * @Date 2021/12/7 16:58
 */
public class UserDao implements IUserDao{

    @Override
    public void save() {
        System.out.println("保存数据");
    }

}
