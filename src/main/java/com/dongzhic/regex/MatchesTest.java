package com.dongzhic.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * matches和lookingAt方法
 *  matches：匹配整个序列
 *  lookingAt：不需要匹配整个序列，从第一个字符开始，只要包含就返回true
 * @author dongzhic
 */
public class MatchesTest {

    private static String REGEX = "foo";
    private static String INPUT1 = "fooooooooooooooooo";
    private static String INPUT2 = "ooooofoooooooooooo";

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher1 = pattern.matcher(INPUT1);
        Matcher matcher2 = pattern.matcher(INPUT2);

        System.out.println("Current REGEX is: "+REGEX);
        System.out.println("Current INPUT1 is: "+INPUT1);
        System.out.println("Current INPUT2 is: "+INPUT2);

        System.out.println("lookingAt(): "+ matcher1.matches());
        System.out.println("matches(): "+ matcher1.lookingAt());
        System.out.println("lookingAt(): "+ matcher2.lookingAt());
    }
}
