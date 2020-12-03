package com.dongzhic.leetcode.primary;

import static sun.misc.MessageUtils.where;

/**
 * @Author dongzhic
 * @Date 2020-11-09 15:33
 */
public class LinkedListApp {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode listNode = middleNode(l1);
        System.out.println(listNode.toString());


    }

    /**
     * 876. 链表的中间结点
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     *
     * 输入：[1,2,3,4,5,6]
     * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
     * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
     *
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {

        ListNode[] listNodes = new ListNode[100];

        int i = 0;
        while (head != null) {
            listNodes[i++] = head;
            head = head.next;
        }

        return listNodes[i/2];

    }


    /**
     * 203. 移除链表元素
     *  删除链表中等于给定值 val 的所有节点。
     *  示例:
     *  输入: 1->2->6->3->4->5->6, val = 6
     *  输出: 1->2->3->4->5
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {

        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode current = sentinel;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return sentinel.next;
    }


    /**
     * 83. 删除排序链表中的重复元素
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     *  示例 1:
     *      输入: 1->1->2
     *      输出: 1->2
     *  示例 2:
     *      输入: 1->1->2->3->3
     *      输出: 1->2->3
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;

        while (current != null && current.next != null) {
           if (current.val == current.next.val) {
                current.next = current.next.next;
           } else {
               current = current.next;
           }
        }

        return head;
    }

    /**
     * 141. 环形链表
     *  给定一个链表，判断链表中是否有环。
     *  如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
     *  我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     *  如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     *  如果链表中存在环，则返回 true 。 否则，返回 false 。
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }


    /**
     * 206. 反转链表
     *  输入: 1->2->3->4->5->NULL
     *  输出: 5->4->3->2->1->NULL
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;


        return newHead;
    }

    public static ListNode reverseList2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null;
        while (head != null) {

            ListNode tempHead = head.next;

            head.next = newHead;
            newHead = head;
            head = tempHead;

        }

        return newHead;
    }

    /**
     * 237. 删除链表中的节点
     *  请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
