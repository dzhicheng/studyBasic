package com.dongzhic.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dongzhic
 */
public class App {


    public static void main(String[] args) {

        Integer num = new Integer(10);

        Map<String, String> map = new HashMap(16);
        map.put("ylCoin", "10");





        String a = test();
        System.out.println(a);
    }

    public static String test () {

        System.out.println();
        try {
            return "zhicheng";
        } finally {
            System.out.println("=========================");
        }
    }
}
