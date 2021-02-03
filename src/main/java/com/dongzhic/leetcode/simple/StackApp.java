package com.dongzhic.leetcode.simple;

import java.util.*;

/**
 * @Author dongzhic
 * @Date 12/8/20 4:48 PM
 */
public class StackApp {

    public static void main(String[] args) {

    }


    /**
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *  有效字符串需满足：
     *  左括号必须用相同类型的右括号闭合。
     *  左括号必须以正确的顺序闭合。
     *  注意空字符串可被认为是有效字符串。
     *
     * 示例 1:
     *  输入: "()"
     *  输出: true
     * 示例 2:
     *  输入: "([)]"
     *  输出: false
     * 示例 3:
     *  输入: "{[]}"
     *  输出: true
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        Map<Character, Character> map = new HashMap<>(16);
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();

        int len = s.length();
        for (int i = 0; i < len; i ++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // 左括号
                stack.push(c);
            } else {
                // 右括号
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char left = stack.pop();

                    if (c != map.get(left)) {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}
