package com.dongzhic.java.reflect.jdk;

/**
 * @Author dongzhic
 * @Date 2021/12/8 10:21
 */
public class UserDao implements IUserDao{

    @Override
    public void save() {
        System.out.println("保存数据");
    }

}
