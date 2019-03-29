package com.dongzhic.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * *：零次或多次匹配前面的字符或子表达式，zo*匹配"z"、"zoo"
 * replaceFirst和replaceAll方法
 *  replaceFirst：替换首次匹配
 *  replaceAll：替换所有匹配
 * @author dongzhic
 */
public class ReplaceTest {

    private static String REGEX = "dog";
    private static String INPUT = "The dog says meow. All dogs say meow.";
    private static String REPLACE = "cat";

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(INPUT);
        INPUT = matcher.replaceFirst(REPLACE);
        System.out.println("replaceFirst：\n" +INPUT);
        INPUT = matcher.replaceAll(REPLACE);
        System.out.println("replaceAll：\n" +INPUT);

    }


}
