package com.dongzhic.leetcode.simple;

/**
 * @Author dongzhic
 * @Date 2020-10-20 10:03
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}
