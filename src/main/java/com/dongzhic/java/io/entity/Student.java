package com.dongzhic.java.io.entity;

import java.io.Serializable;

/**
 * @author dongzc
 * @date 2018/7/2 11:47
 */
public class Student implements Serializable {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
