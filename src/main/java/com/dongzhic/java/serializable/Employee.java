package com.dongzhic.java.serializable;

import java.io.Serializable;

/**
 * 序列化
 *  一个类对象需要序列化
 *   1、必须实现Serializable接口
 *   2、所有属性可序列化，不能用transient修饰
 * @author dongzhic
 */
public class Employee implements Serializable {

    private String name;
    private String address;
    private int number;
    /**
     * transient 不需要序列化
     */
    private transient int snn;

    public void mailCheck() {
        System.out.println("Mailing a check to "+ name
            + "" +address);
    }
}
