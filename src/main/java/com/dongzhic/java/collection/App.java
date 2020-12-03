package com.dongzhic.java.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author dongzhic
 * @Date 2019-12-09 15:20
 */
public class App {

    public static void main(String[] args) {


        Map<String, Object> map = new HashMap<>(16);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        // 方式一
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = (Integer) entry.getValue();
            System.out.print("key: " + key + ", ");
            System.out.println("value:" + value);
        }

        // 方式二
        Iterator<Map.Entry<String, Object>> iterable = map.entrySet().iterator();
        while (iterable.hasNext()) {
            Map.Entry<String, Object> entry = iterable.next();
            String key = entry.getKey();
            Integer value = (Integer) entry.getValue();
            System.out.print("key: " + key + ", ");
            System.out.println("value:" + value);
        }

        // 方式三
        for (String key : map.keySet()) {
            System.out.print("key: " + key);
        }
        for (Object value : map.values()) {
            System.out.println("value:" + value);
        }



    }
}
