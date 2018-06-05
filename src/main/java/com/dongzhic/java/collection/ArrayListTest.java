package com.dongzhic.java.collection;

import java.util.*;

/**
 * @author dongzhic
 */
public class ArrayListTest {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("1");
        list.add("3");
        list.add("4");
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        Map<String, Object> map = new HashMap<String, Object>(16);

        map.put("1","一");
        map.put("2","二");
        map.put("3","三");
        map.put("4","四");

        Set<String> keySet = map.keySet();
        //1、使用迭代器
//        Iterator<String> iterator = keySet.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
        //2、使用foreach遍历
        for (String key : keySet) {
            System.out.println(map.get(key));
        }


        HashSet hashSet = new HashSet();




    }


}
