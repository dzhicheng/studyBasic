package com.dongzhic.java.collection;

import java.security.Key;
import java.util.*;

/**
 * 遍历Map的四种方式
 * 仅需获取key或value使用方法二
 * jdk低于5或遍历时需要删除entry使用方法三
 * 其他情况使用方法一
 *
 * @author dongzc
 * @date 2018/8/7 10:05
 */
public class MapTraversal {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>(16);

        map.put("1", "张三");
        map.put("2", "李四");
        map.put("3", "王五");
        map.put("4", "马六");

        // 方法一：获取key和value
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("key: " + entry.getKey());
            System.out.println("value: " + entry.getValue());
        }

        // 方法二：获取key或value
        for (String key : map.keySet()) {
            System.out.println("key: " + key);
        }
        for (Object value : map.values()) {
            System.out.println("value: " + value);
        }

        // 方法三：通过迭代器
        Iterator<Map.Entry<String, Object>> iterable = map.entrySet().iterator();
        while (iterable.hasNext()) {
            Map.Entry<String, Object> entry = iterable.next();
            System.out.println("key: " + entry.getKey());
            System.out.println("value: " + entry.getValue());
        }

        // 方法四：通过key获取value(效率低)
        for (String key : map.keySet()) {
            Object object = map.get(key);
            System.out.println("key: " + key);
            System.out.println("value: " + object);
        }

    }
}
