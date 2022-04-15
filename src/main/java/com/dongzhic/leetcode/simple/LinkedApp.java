package com.dongzhic.leetcode.simple;

/**
 * 链表
 * @Author dongzhic
 * @Date 11/27/20 3:33 PM
 */
public class LinkedApp {

    public static void main(String[] args) {

       ListNode node1 = new ListNode(1);
       ListNode node2 = new ListNode(1);
       ListNode node3 = new ListNode(1);
       ListNode node4 = new ListNode(1);
       ListNode node5 = new ListNode(1);

       node1.next = node2;
       node2.next = node3;
       node3.next = node4;
       node4.next = node5;


    }


    /**
     * 21. 合并两个有序链表
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * 示例：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

       if (l1 == null) {
           return  l2;
       } else if (l2 == null) {
           return l1;
       } else if (l1.val < l2.val) {

           l1.next = mergeTwoLists(l1.next, l2);
           return l1;
       } else {
           l2.next = mergeTwoLists(l1, l2.next);
           return l2;
       }
    }



    /**
     * 1474. 删除链表 M 个节点之后的 N 个节点
     *  给定链表 head 和两个整数 m 和 n. 遍历该链表并按照如下方式删除节点:
     *      开始时以头节点作为当前节点.
     *      保留以当前节点开始的前 m 个节点.
     *      删除接下来的 n 个节点.
     *      重复步骤 2 和 3, 直到到达链表结尾.
     *  在删除了指定结点之后, 返回修改过后的链表的头节点.
     *
     *  输入: head = [1,2,3,4,5,6,7,8,9,10,11,12,13], m = 2, n = 3
     *  输出: [1,2,6,7,11,12]
     *  解析: 保留前(m = 2)个结点,  也就是以黑色节点表示的从链表头结点开始的结点(1 ->2).
     *  删除接下来的(n = 3)个结点(3 -> 4 -> 5), 在图中以红色结点表示.
     *  继续相同的操作, 直到链表的末尾.
     *  返回删除结点之后的链表的头结点.
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode deleteNodes(ListNode head, int m, int n) {

        int i = 1;
        int j = m + n;
        while (head != null) {


        }

        return head;
    }


}
