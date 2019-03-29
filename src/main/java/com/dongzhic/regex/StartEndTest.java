package com.dongzhic.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * start和end方法
 *  start()：返回以前匹配的初始索引(下标序号)
 *  end()：返回最后匹配字符之后的偏移量(最后匹配字符的下一个数组下标)
 * @author dongzhic
 */
public class StartEndTest {

//    private static final String REGEX = "\\bcat\\b";
//    private static final String INPUT = "cat cat cat cattie cat";

    private static final String REGEX = "\\d+";
    private static final String INPUT = "0 cat catt catre cat cat 9";

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(INPUT);
        int count = 0;

        // 尝试查找与该模式匹配的输入序列的下一个子序列。
        while (matcher.find()) {
            count++;
            System.out.println("Match Number:" + count);
            System.out.println("start():" + matcher.start());
            System.out.println("end():" + matcher.end());

        }
    }
}
