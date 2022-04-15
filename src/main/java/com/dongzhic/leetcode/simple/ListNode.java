package com.dongzhic.leetcode.simple;

/**
 * @Author dongzhic
 * @Date 2020-10-20 10:03
 */
public class ListNode {
    int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}
