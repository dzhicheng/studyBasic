package com.dongzhic.leetcode;

import com.dongzhic.leetcode.common.ListNode;
import com.sun.org.apache.xpath.internal.operations.String;

import java.util.*;

/**
 * @Author dongzhic
 * @Date 2021/10/8 16:24
 */
public class Test {

    public static void main(String[] args) {
        System.out.println();
    }

    /**
     * 143. 重排链表
     * @param head
     */
    public static void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // 正序
        ListNode l1 = head;
        while (l1 != null && l1.next != null) {
            l1.next = l1.next.next;
            l1 = l1.next;
        }




        System.out.println();
    }


    /**
     * 7. 整数反转
     * @param x
     * @return
     */
    public int reverse(int x) {
        long sum = 0;

        while (x != 0) {
            int num = x % 10;
            sum = sum * 10 + num;
            if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
                return 0;
            }

            x = x/10;
        }

        return (int) sum;
    }

    /**
     * 53. 最大子序和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int maxSub = nums[0];
        int currSub = nums[0];
        for (int i = 1; i < nums.length; i++) {

            int num = nums[i];
            if (currSub < 0) {
                currSub = num;
            } else {
                currSub += num;
            }

            if (currSub > maxSub) {
                maxSub = currSub;
            }
        }

        return maxSub;
    }

    /**
     * 21. 合并两个有序链表：递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            ListNode nextNode = mergeTwoLists1(l1.next, l2);
            l1.next = nextNode;
            return l1;
        } else {
            ListNode nextNode = mergeTwoLists1(l1, l2.next);
            l2.next = nextNode;
            return l2;
        }
    }

    /**
     * 21. 合并两个有序链表：迭代
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode mergeNode = new ListNode(-1);
        ListNode currNode = mergeNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                currNode.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                currNode.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            currNode = currNode.next;
        }

        if (l1 != null) {
            currNode.next = l1;
        }
        if (l2 != null) {
            currNode.next = l2;
        }

        return mergeNode.next;
    }

    /**
     * 1. 两数之和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num)) {
                return new int[]{i, map.get(target - num)};
            }
            map.put(num, i);
        }

        return null;
    }

    /**
     * 206. 反转链表：递归
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
     * 206. 反转链表：迭代
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null;
        while (head != null) {
           ListNode nextNode = head.next;

           head.next = newHead;
           newHead = head;

           head = nextNode;
        }

        return newHead;
    }

    /**
     * 15. 三数之和
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * a + b + c = 0
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> resultList = new ArrayList<>();
        Set<List<Integer>> resultSet = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int target = 0 - nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                int diff = target - nums[j];
                if (map.containsKey(diff)) {
                    resultSet.add(Arrays.asList(nums[i], nums[j], diff));
                    map.remove(diff);
                }
                map.put(nums[j], j);
            }
        }

        if (resultSet.size() > 0) {
            resultList.addAll(resultSet);
        }

        return resultList;
    }

    public List<List<Integer>> threeSum2(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> resultList = new ArrayList<>();
        Set<List<Integer>> resultSet = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int target = 0 - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    resultSet.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        if (resultSet.size() > 0) {
            resultList.addAll(resultSet);
        }

        return resultList;
    }



}
