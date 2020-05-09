package com.newcode_offer.矩形覆盖;

/**
 * @author KyrieXu
 * @since 2020/4/4 22:51
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 **/
public class s01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.RectCover(8));
    }
}

class Solution {
    /**
     * 这个其实还是和斐波拉契数列同根同源的
     * 可以横着放，也可以竖着放
     * 如果是横着放的话，那么就是有2*(n-2)种情况
     * 如果是竖着方式话那么还有2*(n-1)种情况
     *
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if (target == 1)
            return 1;
        int fib1 = 1, fib2 = 1, res = 0;
        for (int i = 0; i <= target - 2; i++) {
            res=fib1+fib2;
            fib2=fib1;
            fib1=res;
        }
        return res;
    }
}
