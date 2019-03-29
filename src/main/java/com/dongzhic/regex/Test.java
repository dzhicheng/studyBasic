package com.dongzhic.regex;

/**
 * @author dongzhic
 */
public class Test {


    private static String INPUT = " Hello,  today\t is\n your birthday中国 ";
    private static String REGEX = "[a-zA-Z]+('?[a-zA-Z])?";

    public static void main(String[] args) {
        String a = INPUT.replaceAll("\t|\n|\r|,", " ");
        String b = a.replaceAll("[\u2E80-\u9FFF]", "").trim();
        String result = b.replaceAll("\\s+", ",");
        String[] str = result.split(",");


        System.out.println(b);
        System.out.println(result);
    }
}
