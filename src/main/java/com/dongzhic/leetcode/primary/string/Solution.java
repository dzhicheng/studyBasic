package com.dongzhic.leetcode.primary.string;

import java.util.*;

/**
 * @author dongzhic
 */
public class Solution {

    public static void main(String[] args) {
        String a = new String("abc");
        String b = a;
        a = "123";
        System.out.println(a);
        System.out.println(b);



//        String a = "1010";
//        String b = "1011";
//        String result = addBinary(a, b);
//        System.out.println(result);

    }

    /**
     * 二进制相加 11 1
     * @param a
     * @param b
     * @return
     */
    public static String addBinary (String a, String b) {

        StringBuilder result = new StringBuilder();

        // 进位
        int carry = 0;
        int alen = a.length()-1;
        int blen = b.length()-1;

        while(alen >= 0 || blen >=0) {
            // sum%2：当前位，sum/2：进位
            int sum = carry;

            if (alen >= 0) {
                sum += a.charAt(alen) - '0';
                alen--;
            }

            if (blen >= 0) {
                sum += b.charAt(blen) - '0';
                blen--;
            }

            result.append(sum%2);
            carry = sum/2;

        }
        if (carry != 0) {
            result.append(1);
        }
        return result.reverse().toString();
    }

    private static String[] map = {
            ".-",
            "-...",
            "-.-.",
            "-..",
            ".",
            "..-.",
            "--.",
            "....",
            "..",
            ".---",
            "-.-",
            ".-..",
            "--",
            "-.",
            "---",
            ".--.",
            "--.-",
            ".-.",
            "...",
            "-",
            "..-",
            "...-",
            ".--",
            "-..-",
            "-.--",
            "--.."
    };

    public static int uniqueMorseRepresentations(String[] words) {


        if (words == null) return 0;
        HashSet<String> set = new HashSet<String>();
        for (String s : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                int i = c - 'a';
                sb.append(map[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();

//        HashSet set = new HashSet();
//        for (int i = 0; i < words.length; i ++) {
//            String s = enCode(words[i]);
//            set.add(s);
//        }
//
//        return set.size();
    }

    public static String enCode (String word) {

        StringBuilder result = new StringBuilder();

        final String[] a = new String[]{".-","-...","-.-.","-..",".",
                "..-.","--.","....","..",".---","-.-",
                ".-..","--","-.","---",".--.","--.-",".-.","...",
                "-","..-","...-",".--","-..-","-.--","--.."};
        final String[] b = new String[]{"a", "b", "c", "d", "e", "f", "g",
                "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
                "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        HashMap<String, String> map = new HashMap<>(16);
        for (int i = 0; i < 26; i ++) {
            map.put(b[i], a[i]);
        }

        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i ++) {
            char c = chars[i];
            result.append(map.get(String.valueOf(c)));
        }

        return result.toString();
    }





    public static int numUniqueEmails(String[] emails) {
        Set<String> hashSet = new HashSet<String>();
        for (int i = 0; i < emails.length; i++) {
            StringBuilder s = new StringBuilder();
            String[] str = emails[i].split("@");
            if (str.length == 2) {
                String localName = str[0];
                String domainName = str[1];
                String[] addStr = localName.split("\\+");
                s.append(addStr[0].replaceAll("\\.", ""));
                s.append("@");
                s.append(domainName);
                hashSet.add(s.toString());
            }
        }
        return hashSet.size();
    }

    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }
}
