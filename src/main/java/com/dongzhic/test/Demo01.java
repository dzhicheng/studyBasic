package com.dongzhic.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author dongzhic
 * @Date 2021/10/27 20:36
 */
public class Demo01 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(showCount(a, b));
//            System.out.println(showCount1(a, b));
        }
    }

    /**
     * 数字统计
     * @param n 正整数N,N>0
     * @param m 整数M,0<=M<=9
     * @return
     */
    public static int showCount (int n, int m) {

        int count = 0;

        char c = String.valueOf(m).charAt(0);
        for (int i = 0; i <= n; i++) {
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == c) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int showCount1 (int n, int m) {

        int count = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i <= n; i++) {
            String s = String.valueOf(i);
            int num = i;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
        }

        char mChar = String.valueOf(m).charAt(0);
        if (map.containsKey(mChar)) {
            count = map.get(mChar);
        }

        return count;
    }
}
