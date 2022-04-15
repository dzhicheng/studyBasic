package com.dongzhic;

import lombok.Data;

import java.util.*;

/**
 * @Author dongzhic
 * @Date 2021/11/3 11:38
 */
public class Test {

    public static void main(String[] args) {

        String s = null;

        System.out.println(s.equals("abc"));


    }

}

@Data
class Student {
    private Integer number;
    private String name;
}
