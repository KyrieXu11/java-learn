package com.leetcode.删除排序数组中的重复项_26;

/**
 * @author KyrieXu
 * @since 2020/5/1 10:52
 **/
public class Main {



    public int removeDuplicates(int[] nums) {
        int len = 0;
        if (nums.length == 0) return len;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[len]) {
                len++;
                nums[len] = nums[i];
            }
        }
        return ++len;
    }
}
