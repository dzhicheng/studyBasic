package com.dongzhic.design.patterns.proxy.staticproxy;

/**
 * 接口实现
 * 目标对象
 * @author dongzc
 * @date 2018/7/3 10:03
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("已经保存成功！");
    }
}
