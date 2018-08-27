package com.dongzhic.java.collection;

import java.security.Key;
import java.util.*;

/**
 * 遍历Map的三种方式
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

        // 方法一：获取key-value的set集合，再遍历
        System.out.println("===================1.获取key-value的set集合，再遍历=====================");
        // 1. 获取key-value对（Entr    y）的set集合
        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
        // 2. 遍历set集合，获取key-value
        // 2.1 通过for循环
        for (Map.Entry<String, Object> entry : entrySet) {
            System.out.print("key:" + entry.getKey());
            System.out.println("，value:" + entry.getValue());
        }
        System.out.println("================");
        // 2.2 通过迭代器，先获取key-value对（Entry）的Iterator，再循环遍历
        Iterator iterator1 =  entrySet.iterator();
        while (iterator1.hasNext()) {
            // 先获取Entry，再获取key-value
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) iterator1.next();
            System.out.print("key:"+entry.getKey());
            System.out.println("，value:"+entry.getValue());
        }
        System.out.println("===================1.获取key-value的set集合，再遍历=====================");

        // 方法二：获取key的set集合，再遍历
        System.out.println("===================2.获取key的set集合，再遍历=====================");
        // 1. 获取key的set集合
        Set<String> keySet = map.keySet();
        // 2. 遍历set集合，通过key获取value
        for (String key : keySet) {
            System.out.print("key:"+ key);
            System.out.println("，value:"+ map.get(key));
        }
        System.out.println("================");
        Iterator iterator2 = keySet.iterator();
        String key = null;
        while (iterator2.hasNext()) {
            key = (String) iterator2.next();
            System.out.print("key:"+ key);
            System.out.println("，value:"+ map.get(key));
        }
        System.out.println("===================2.获取key的set集合，再遍历=====================");

        // 方法三：获取value的set集合，再遍历
        System.out.println("===================3.获取value的set集合，再遍历=====================");
        // 1.获取value的set集合
        Collection valueSet = map.values();
        // 2.遍历set集合，获取value
        Iterator iterator3 = valueSet.iterator();
        while (iterator3.hasNext()) {
            System.out.println(iterator3.next());
        }
        System.out.println("===================3.获取value的set集合，再遍历=====================");

    }
}
