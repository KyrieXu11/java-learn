package com.newcode_offer.连续子数组的最大和;

/**
 * @author KyrieXu
 * @since 2020/4/25 13:59
 **/
public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(FindGreatestSumOfSubArray(array));
    }

    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0)
            return 0;
        int currentSum = 0, GratestSum = Integer.MIN_VALUE;
        for (int i : array) {
            // 当前的求和如果小于0就舍弃掉之前的和
            // 从当前的这一项开始求和
            if (currentSum <= 0)
                currentSum = i;
            else
                currentSum += i;
            if (currentSum > GratestSum)
                GratestSum = currentSum;
        }
        return GratestSum;
    }
}
