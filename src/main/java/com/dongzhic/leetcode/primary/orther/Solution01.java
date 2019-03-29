package com.dongzhic.leetcode.primary.orther;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Solution01 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum2(nums, target);
        System.out.println("["+result[0] +", " + result[1] +"]");
    }

    public static int[] twoSum1(int[] nums, int target) {

        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++){
                if (nums[j] == (target - nums[i])) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("no two sum solution");

    }

    public static int [] twoSum2 (int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int j=0; j<nums.length; j++) {
            int complement = target - nums[j];
            if (map.containsKey(complement) && map.get(complement) != j) {
                return new int[] {j, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("no two sum solution");
    }
}
