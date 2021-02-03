package com.dongzhic.leetcode.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author dongzhic
 * @Date 2019-11-11 17:39
 */
public class App {

    public static void main(String[] args) {

        int[] A = {1,2};
        int[] B = {2,3};

        System.out.println(Arrays.stream(A).sum());
        System.out.println(Arrays.stream(B).sum());

//        int[] C = fairCandySwap(A, B);
//
//        for (int i = 0; i < C.length; i ++) {
//            System.out.println(C[i]);
//        }

    }


    /**
     * 888. 公平的糖果棒交换
     *
     *  输入：A = [1,1], B = [2,2]
     *  输出：[1,2]
     * @param A
     * @param B
     * @return
     */
    public static int[] fairCandySwap(int[] A, int[] B) {

        int [] result = new int[2];

        int aliceNum = Arrays.stream(A).sum();
        int bobNum = Arrays.stream(B).sum();

        for (int i = 0; i < A.length; i ++) {

            int temp1 = aliceNum;
            int temp2 = bobNum;
            int a = A[i];

            for (int j =0; j < B.length; j ++) {
                int b = B[j];

                if ((aliceNum-a+b) == (bobNum-b+a)) {
                    result[0] = a;
                    result[1] = b;
                    return result;
                }
            }

        }

        return result;
    }


    /**
     * 1128. 等价多米诺骨牌对的数量(暴力解法)
     *  给你一个由一些多米诺骨牌组成的列表 dominoes。
     *  如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
     *  形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
     *  在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
     *
     *  输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
     *  输出：1
     * @param dominoes
     * @return
     */
    public static int numEquivDominoPairs1(int[][] dominoes) {

        int num = 0;

        for (int i = 0; i < dominoes.length; i ++) {
            for (int j = i + 1; j < dominoes.length; j ++) {
                if ((dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1]) ||
                        (dominoes[i][0] == dominoes[j][1] && dominoes[i][1] == dominoes[j][0])) {
                    num++;
                }
            }
        }

        return num;
    }

    /**
     * 53. 最大子序和
     *  给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *  输入: [-2,1,-3,4,-1,2,1,-5,4]
     *  输出: 6
     *  解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {

        int maxSub = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }

            if (sum > maxSub) {
                maxSub = sum;
            }
        }

        return maxSub;
    }


    /**
     * 35. 搜索插入位置
     *  给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *  你可以假设数组中无重复元素。
     *  输入: [1,3,5,6], 5
     *  输出: 2
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {

        for (int i = 0; i < nums.length; i ++ ) {

            int num = nums[i];

            if (target < num) {
                return 0;
            } else if (target == num) {
                return i;
            } else if (i != nums.length-1 && target >num && target < nums[i+1]){
                return i + 1;
            }

        }
        return nums.length;

    }

    /**
     * 27. 移除元素
     *  给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     *  不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     *  元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *  示例 1:
     *      给定 nums = [3,2,2,3], val = 3,
     *      函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
     *      你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {

        int i = 0;

        for (int j = 0; j < nums.length; j ++) {

            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * 21. 合并两个有序链表
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *  示例：
     *  输入：1->2->4, 1->3->4
     *  输出：1->1->2->3->4->4
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode l3 = new ListNode();

        while (l1.next != null) {

        }


        return l3;
    }




    /**
     * 509. 斐波那契数
     * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     *  F(0) = 0,   F(1) = 1
     *  F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     *  给定 N，计算 F(N)。
     * @param N
     * @return
     */
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int first = 0;
        int second = 1;
        for (int i = 1; i < n ; i ++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    /**
     * 魔术索引
     *  在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，
     *  若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
     * @param nums
     * @return
     */
    public static int findMagicIndex(int[] nums) {

        int result = 0;

        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == i) {
                result = i;
                break;
            }
        }

        return result;
    }


    /**
     * 给一个 非空 字符串 s 和一个单词缩写 abbr ，判断这个缩写是否可以是给定单词的缩写。
     * 字符串 "word" 的所有有效缩写为：
     * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
     * 注意单词 "word" 的所有有效缩写仅包含以上这些。任何其他的字符串都不是 "word" 的有效缩写。
     * 注意: 假设字符串 s 仅包含小写字母且 abbr 只包含小写字母和数字。
     *
     * @param word
     * @param abbr
     * @return
     */
    public static boolean validWordAbbreviation(String word, String abbr) {

        if (abbr.length() > word.length() || '0' == abbr.charAt(0)) {
            return false;
        }

        // 2.判断是否包含数字
        if (!hasDigit(abbr)) {
            // 不包含数字
           return abbr.equals(word);
        } else {
            if (abbr.length() == 1 && hasDigit(abbr)) {
                return word.length() == Integer.parseInt(abbr);
            }
            int index = 0;
            char [] chars = abbr.toCharArray();
            for (int i = 0; i < chars.length; i ++) {
                char c = chars[i];
                if (word.contains(String.valueOf(c))) {
                    index++;
                    continue;
                } else {
                    if (hasDigit(String.valueOf(c))) {

                        if (i > 0 && '0' == c && word.contains(String.valueOf(chars[i-1])) ) {
                            return false;
                        }

                        if (i < chars.length-1 && hasDigit(String.valueOf(chars[i+1]))) {
                            index += Integer.parseInt(String.valueOf(c)) * 10 + Integer.parseInt(String.valueOf(chars[i+1]));
                            i ++;
                        } else {
                            index += Integer.parseInt(String.valueOf(c));
                        }
                        continue;
                    } else {
                        return false;
                    }
                }
            }

            return index == word.length();
        }
    }

    public static boolean hasDigit (String s) {
        boolean flag = false;

//        Pattern p = Pattern.compile(".*\\d+.*");
//        Matcher m = p.matcher(s);
//        if (m.matches()) {
//            flag = true;
//        }

        for (int i = 0; i < s.length(); i ++){
            if (Character.isDigit(s.charAt(i))) {
                flag = true;
                break;
            }
        }

        return flag;
    }


    /**
     * 293. 翻转游戏
     *  你和朋友玩一个叫做「翻转游戏」的游戏，游戏规则：给定一个只有 + 和 - 的字符串。你和朋友轮流将 连续 的两个 "++" 反转成 "--"。
     *  当一方无法进行有效的翻转时便意味着游戏结束，则另一方获胜。
     *  请你写出一个函数，来计算出第一次翻转后，字符串所有的可能状态。
     *
     *  输入: s = "++++"
     * 输出:
     * [
     *   "--++",
     *   "+--+",
     *   "++--"
     * ]
     *
     * 如果不存在可能的有效操作，请返回一个空列表 []。
     *
     * @param s
     * @return
     */
    public static List<String> generatePossibleNextMoves(String s) {

        List<String> resultList = new ArrayList<>();

        int len = s.length();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length-1; i ++) {
            String str = "";
            char c = chars[i];
            if (chars[i] == '+' && chars[i+1] == '+') {
                str = s.substring(0, i) + "--" + s.substring(i+2, len);
                resultList.add(str);
            }
        }

        return resultList;
    }


    private String file = "abcde";
    /**
     * 157. 用 Read4 读取 N 个字符
     * @param buf
     * @param n
     * @return
     */
    public static int read(char[] buf, int n) {
        return 0;
    }


    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     *
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int [0];
        }
        int rows = matrix.length;
        int columns = matrix[0].length;

        int left = 0, right = columns -1, top = 0, bottom = rows -1;

        int [] order = new int[rows * columns];
        int index = 0;

        while (left <= right && top <= bottom) {

            for (int column = left; column <= right; column ++) {
                order[index++] = matrix[top][column];
            }

            for (int row = top + 1; row <= bottom; row ++) {
                order[index++] = matrix[row][right];
            }

            if (left < right && top < bottom) {

                for (int column = right - 1; column > left; column --) {
                    order[index++] = matrix[bottom][column];
                }
                for (int row = bottom ; row > top; row --) {
                    order[index++] = matrix[row][left];
                }
            }

            left++;
            top++;
            right--;
            bottom--;
        }
        return order;
    }


    /**
     * 求1+2+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     * 输入: n = 3
     * 输出: 6
     * @param n
     * @return
     */
    private static int res = 0;
    public static int sumNums(int n) {
        boolean x = (n > 1) && (sumNums(n-1) > 0);
        res += n;
        return res;
    }

    /**
     * 1431. 拥有最多糖果的孩子
     *  给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
     *  对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。
     *  注意，允许有多个孩子同时拥有 最多 的糖果数目。
     *
     * 输入：candies = [2,3,5,1,3], extraCandies = 3
     * 输出：[true,true,true,false,true]
     * 解释：
     * 孩子 1 有 2 个糖果，如果他得到所有额外的糖果（3个），那么他总共有 5 个糖果，他将成为拥有最多糖果的孩子。
     * 孩子 2 有 3 个糖果，如果他得到至少 2 个额外糖果，那么他将成为拥有最多糖果的孩子。
     * 孩子 3 有 5 个糖果，他已经是拥有最多糖果的孩子。
     * 孩子 4 有 1 个糖果，即使他得到所有额外的糖果，他也只有 4 个糖果，无法成为拥有糖果最多的孩子。
     * 孩子 5 有 3 个糖果，如果他得到至少 2 个额外糖果，那么他将成为拥有最多糖果的孩子。
     *
     * @param candies
     * @param extraCandies
     * @return
     */
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> result = new ArrayList<>();

        int maxNum = 0;
        for (int i = 0 ; i < candies.length; i ++) {
            if (maxNum < candies[i]) {
                maxNum = candies[i];
            }
        }

        for (int i = 0 ; i < candies.length; i ++) {
            if (candies[i] + extraCandies >= maxNum) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }


    /**
     * 14. 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     *      如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *      给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     *
     *      输入: [1,2,3,1]
     *      输出: 4
     *      解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *          偷窃到的最高金额 = 1 + 3 = 4 。
     *
     * @param strs
     * @return
     */
    public static int rob(int[] nums) {

        int len = nums.length;

        int [] dp = new int[len+1];

        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i < nums.length+1; i ++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return dp[len];
    }

    public static int max (int a, int b) {
        if (a > b) {
            return b;
        }
        return b;
    }

    /**
     * 9. 回文数
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        return reverse2(x) == x ? true : false;
    }

    /**
     * 7：整数反转：给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * 输入: -123 -110
     * 输出: -321 -11
     * @param x
     * @return
     */
    public static int reverse1(int x) {
        List<Character> list = new ArrayList<>();

        String num = String.valueOf(x);
        char[] chars = num.toCharArray();
        // 循环起始位置
        int start = 0;
        if ('-' == chars[0]) {
            start ++;
            list.add('-');
        }
        for (int i = chars.length - 1; i >= start ; i --) {
            char c = chars[i];
            if (i == chars.length - 1) {
                if ('0' != c) {
                    list.add(c);
                }
            } else {
                list.add(c);
            }
        }

        char[] result = new char[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            result[i]= list.get(i);
        }

        long resultOfLong = Long.valueOf(String.valueOf(result));

        if (resultOfLong > Integer.MAX_VALUE || resultOfLong < Integer.MIN_VALUE) {
            return 0;
        } else {
            return Integer.valueOf(String.valueOf(result));
        }
    }

    /**
     * 7：整数反转：给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * 输入: 123 -123 -110
     * 输出: 321 -321 -11
     * @param x
     * @return
     */
    public static int reverse2(int x) {

        long result = 0;
        while (x != 0) {
            result = result*10 + x%10;
            x = x/10;
        }

        if ((int)result != result) {
            return  0;
        } else {
            return (int)result;
        }
    }





}
