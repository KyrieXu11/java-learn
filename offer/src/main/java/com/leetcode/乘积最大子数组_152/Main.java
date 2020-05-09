package com.leetcode.乘积最大子数组_152;

/**
 * @author KyrieXu
 * @since 2020/5/1 10:37
 **/
public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{2,3,-2,4};
        System.out.println(maxProduct(array));
    }

    // 参考young gc 的survivor 0 1区的交换算法
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int num : nums) {
            // 小于0 的话会让最小的变成最大的最大的变成最小的
            // 所以得交换一下
            if (num < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax=Math.max(imax*num,num);
            imin=Math.min(imin*num,num);
            max=Math.max(max,imax);
        }
        return max;
    }


    public int maxProduct1(int[] nums) {
        if (nums.length == 1) return nums[0];
        int maxNum = 0;
        int[] a = new int[nums.length - 1];
        int maxTemp = nums[0];
        maxNum = nums[0] * nums[1];
        for (int i = 0; i < nums.length - 1; i++) {
            maxTemp = Math.max(maxTemp, nums[i + 1]);
            a[i] = nums[i] * nums[i + 1];
            a[i] = Math.max(a[i], maxTemp);
            maxNum = Math.max(maxNum, a[i]);
        }
        return maxNum;
    }
}
