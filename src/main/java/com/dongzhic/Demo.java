package com.dongzhic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @Author dongzhic
 * @Date 6/17/21 9:15 PM
 */
public class Demo {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(3);

        Method method;
        try {
            method = list.getClass().getMethod("add", Object.class);

            method.invoke(list, "aaa");


            System.out.println(list.toString());

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    public static void test1 () {
        List<String> list=new ArrayList<>();
        list.add("M04-002-001");
        list.add("M3-602-001");
        list.add("M104-003-001");
        list.add("M103-002-11");
        list.add("M18-002-001");
        list.add("J01-002-001");
        list.add("A101-052-001");

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(list);
    }

    /**
     * 压缩字符串
     * 输入aaabb，输出3a2b
     * @param str
     * @return
     */
    public static String compress (String str) {

        StringBuffer sb = new StringBuffer();

        if (str == null || "".equals(str)) {
            return sb.toString();
        }

        char c = str.charAt(0);
        int count = 0;

        for (int i = 0; i < str.length(); i ++) {
            if (str.charAt(i) == c) {
                count++;
            } else {
                sb.append(count);
                sb.append(c);

                c = str.charAt(i);
                count = 1;
            }
        }

        sb.append(count);
        sb.append(c);

        return sb.toString();
    }



}
