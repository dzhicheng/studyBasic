package com.dongzhic.jvm;

/**
 * @Author dongzhic
 * @Date 3/24/21 6:56 PM
 */
public class User1 {

    private Integer userId;
    private String username;

    public User1 () {

    }

    public User1 (Integer userId, String username) {
        super();
        this.userId = userId;
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void sout () {
        System.out.println("=======自己的加载器加载类调用方法=======");
    }
}
