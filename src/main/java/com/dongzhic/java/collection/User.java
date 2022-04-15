package com.dongzhic.java.collection;

import lombok.Data;

/**
 * @Author dongzhic
 * @Date 2021/9/28 15:25
 */
@Data
//public class User implements Comparable<User> {
public class User {
    private String username;
    private Integer age;

    public User() {}
    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    /**
     * 负数：当前入参比本身小
     * 0：当前入参比本身相等
     * 正数：当前入参比本身大
     * @param o
     * @return
     */
//    @Override
//    public int compareTo(User o) {
//        // 倒叙
////        return o.age - this.age;
//        return this.age - o.age;
//    }
}
