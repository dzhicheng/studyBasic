package com.dongzhic.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * appendReplacement()和appendTail()方法
 *  appendReplacement：将最后匹配之前的子串添加到StringBuffer对象中
 *  appendTail：将最后匹配到后面的子串添加到StringBuffer对象中
 * @author dongzhic
 */
public class AppendReplacementTest {

    private static String REGEX = "a*b";
    private static String INPUT = "kkkaabfooaabfooabfoobkkk";
    private static String REPLACE = "-";

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(INPUT);
        StringBuffer sb = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(sb, REPLACE);
        }
        System.out.println(sb.toString());
        matcher.appendTail(sb);
        System.out.println(sb.toString());
    }
}
