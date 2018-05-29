package com.dongzhic.java.Serializable;

import java.io.Serializable;

/**
 * 用户类
 * @author dongzhic
 * @date 2018.05.16
 */
public class User implements Serializable {

    private String name;
    private transient String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
