package com.leetcode.最大子序和_53;

/**
 * @author KyrieXu
 * @since 2020/4/30 17:00
 * <p>
 * 给定一个整数数组 nums ，
 * 找到一个具有最大和的 连续子数组 （子数组最少包含一个元素），返回其最大和
 **/
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray1(nums));
    }

    // 暴力求解
    public static int maxSubArray1(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max)
                    max = sum;
            }
        }
        return max;
    }


    // 动态规划
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
        }
        int max = dp[0];
        for (int i : dp) {
            if (max < i)
                max = i;
        }
        return max;
    }
}
