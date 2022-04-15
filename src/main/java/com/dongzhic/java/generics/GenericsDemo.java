package com.dongzhic.java.generics;

import com.dongzhic.datastructures.List;
import com.dongzhic.datastructures.array.ArrayList;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 泛型案例
 * @Author dongzhic
 * @Date 6/18/21 5:14 PM
 */
public class GenericsDemo {


    public static void main(String[] args) {

        // java的泛型是伪泛型


        //==================案例一
        List<String> list = new ArrayList<>();
        list.add("aaa");
        try {
            Method method = list.getClass().getMethod("add", Object.class);
            method.invoke(list, 3);

            // 输出：size = 2, [aaa,3]
            System.out.println(list.toString());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //==================案例二
        Map<String, String> map = new HashMap<>();
        map.put("name", "张三");

        Method method2 = null;
        try {
            method2 = HashMap.class.getDeclaredMethod("put", new Class[]{Object.class, Object.class});
            method2.invoke(map,"age", 26);

            // java.lang.Integer cannot be cast to java.lang.String
//        System.out.println(map);

//        System.out.println(map.get("age"));

            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }






    }
}
