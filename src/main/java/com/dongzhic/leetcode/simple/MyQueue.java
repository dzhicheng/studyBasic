package com.dongzhic.leetcode.simple;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * 思路：
 *  入栈时：push到inStack中
 *  出栈时：
 *      如果outStack不为空，弹出outStack栈顶元素
 *      如果outStack为空，先将inStack元素依次，push到outStack，然后弹出outStack栈顶元素
 * @Author dongzhic
 * @Date 1/8/21 5:08 PM
 */
public class MyQueue {

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);

        System.out.println(obj.pop());
        System.out.println(obj.peek());
        System.out.println(obj.empty());

//        int param_2 = obj.pop();
//        int param_3 = obj.peek();
//        boolean param_4 = obj.empty();
    }

    /**
     * 只负责入栈
     */
    private Stack<Integer> inStack;
    /**
     * 只负责出栈
     */
    private Stack<Integer> outStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        inStack = new Stack();
        outStack = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (inStack.isEmpty() && outStack.isEmpty()) {
            return true;
        }
        return false;
    }

}
