package com.dongzhic.leetcode.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author dongzhic
 * @Date 6/24/21 9:21 AM
 */
public class Demo03 {

    public static void main(String[] args) {
        String s = "String";
        System.out.println(s.substring(1, 2));
    }

    /**
     * 2. 两数相加
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode newNode = new ListNode(0);
        ListNode currNode = newNode;

        int carry = 0;
        while (l1 != null || l2 != null) {

            int sum;
            if (l1 == null) {
                sum = l2.val + carry;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val + carry;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }

            carry = sum/10;

            ListNode node = new ListNode(sum%10);
            currNode.next = node;
            currNode = currNode.next;

        }

        if (carry == 1) {
            ListNode node = new ListNode(carry);
            currNode.next = node;
        }

        return newNode.next;
    }



    /**
     * 70. 爬楼梯
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        // 用数组存储次数
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i ++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }


    /**
     * 14. 最长公共前缀
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {

        if (strs == null) {
            return null;
        }

        if (strs.length == 1) {
            return strs[0];
        }

        String commonPrefix = strs[0];

        for (int i = 1; i < strs.length; i ++) {
            commonPrefix = getCommonPrefix(commonPrefix, strs[i]);
        }

        return commonPrefix;
    }

    public static String getCommonPrefix (String s1, String s2) {

        if (s1.isEmpty() || s2.isEmpty()) {
            return "";
        }

        int len = Math.min(s1.length(), s2.length());
        int index = 0;
        for (int i = 0; i < len; i ++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                index++;
                continue;
            } else {
                break;
            }
        }

        return s1.substring(0, index);
    }


    /**
     * 回文数
     * @param x
     * @return
     */
    public boolean isPalindrome1(int x) {

        if ( x < 0) {
            return false;
        }

        int palindrome = 0;
        int num = x;
        while (num != 0) {
            palindrome = palindrome*10 + num%10;
            num = num/10;
        }

        if (palindrome == x) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 回文数
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {

        if (x < 0) {
            return false;
        }

        String s = String.valueOf(x);
        int len = s.length();
        for (int i = 0; i < len/2; i ++) {
            if (s.charAt(i) != s.charAt(len-1-i)) {
                return false;
            }
        }

        return true;
    }


    /**
     * 20. 有效的括号 ()
     * @param s
     * @return
     */
    public static boolean isValid(String s) {

        if (s == null || "".equals(s)) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {

                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() == map.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }

            } else {
                stack.push(c);
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 53. 最大子序和
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {

        if (nums == null) {
            return 0;
        }

        // 最大子序和
        int maxSum = nums[0];
        // 当前子序和
        int currSum = nums[0];

        for (int i = 1; i < nums.length; i ++) {

            if (currSum < 0) {
                currSum = nums[i];
            } else {
                currSum += nums[i];
            }

            if (currSum > maxSum) {
                maxSum = currSum;
            }

        }

        return maxSum;

    }

    /**
     * 53. 最大子序和:暴力法
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {

        if (nums == null) {
            return 0;
        }

        int maxSum = nums[0];

        for (int i = 0; i < nums.length; i ++) {
            int sum = 0;
            for (int j = i; j < nums.length; j ++) {
                sum += nums[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;

    }


    /**
     * 7. 整数反转
     * @param x
     * @return
     */
    public int reverse(int x) {

        long result = 0;

        while (x != 0) {
            result = result*10 + x%10;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
            x = x/10;
        }

        return (int) result;
    }


    /**
     * 21. 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode result = new ListNode(-1);
        ListNode newNode = result;
        while (l1 != null || l2 != null) {

            ListNode currNode;
            if (l1 == null) {
                currNode = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l2 == null) {
                currNode = new ListNode(l1.val);
                l1 = l1.next;
            } else {

                if (l1.val < l2.val) {
                    currNode = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    currNode = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }

            newNode.next = currNode;
            newNode = newNode.next;
        }

        return result.next;
    }

    /**
     * 1. 两数之和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        int [] result = new int[2];

        if (nums == null) {
            return result;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i ++) {
            int key = nums[i];
            if (map.containsKey(target - key)) {
                result[0] = map.get(target - key);
                result[1] = i;
                return result;
            } else {
                map.put(key, i);
            }
        }

        return result;
    }

    /**
     * 206. 反转链表:递归
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode nextNode = reverseList1(head.next);
        head.next.next = head;
        head.next = null;

        return nextNode;
    }

    /**
     * 206. 反转链表:非递归
     * 1->2->3->4
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null;
        while (head != null) {
            ListNode currNode = head.next;

            head.next = newHead;
            newHead = head;
            head = currNode;
        }

        return newHead;

    }

}
