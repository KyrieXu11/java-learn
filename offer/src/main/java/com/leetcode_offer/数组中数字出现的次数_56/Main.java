package com.leetcode_offer.数组中数字出现的次数_56;

import com.common.listnode.Solution;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author KyrieXu
 * @since 2020/5/3 11:58
 **/
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 4, 6};
        int[] res = SingleNumbers1(nums);
        List<Integer> list = Arrays.stream(res).boxed().collect(Collectors.toList());
        System.out.println(list);
    }

    // 时间复杂度为O(n)，但是空间复杂度不为O(1)
    public static int[] singleNumbers(int[] nums) {
        int[] hash = new int[1000];
        int[] res = new int[2];
        for (int num : nums) {
            hash[num]++;
        }
        int cnt = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == 1) {
                res[cnt] = i;
                ++cnt;
            }
        }
        return res;
    }

    public static int[] SingleNumbers1(int[] nums) {
        int xorSum = 0;
        int[] ret = new int[2];
        for (int x : nums)
            xorSum ^= x;
        int lowbit = xorSum & (-xorSum);
        for (int x : nums)
            ret[(x & lowbit) > 0 ? 0 : 1] ^= x;
        return ret;
    }
}
