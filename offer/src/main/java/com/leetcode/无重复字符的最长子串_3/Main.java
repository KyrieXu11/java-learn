package com.leetcode.无重复字符的最长子串_3;

import java.util.Arrays;

/**
 * @author KyrieXu
 * @since 2020/5/2 13:39
 **/
public class Main {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbbbbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] nums = new int[256];
        Arrays.fill(nums, -1);
        int maxLen = 0, flag = -1;
        for (int i = 0; i < s.length(); i++) {
            if (nums[s.charAt(i)] > flag)
                flag = nums[s.charAt(i)];
            nums[s.charAt(i)] = i;
            maxLen = Math.max(maxLen, i - flag);
        }
        return maxLen;
    }
}
