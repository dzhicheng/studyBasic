package com.dongzhic.datastructures;

import com.dongzhic.datastructures.stack.Stack;

/**
 * @Author dongzhic
 * @Date 12/4/20 11:13 AM
 */
public class StackApp {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.push(44);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}
