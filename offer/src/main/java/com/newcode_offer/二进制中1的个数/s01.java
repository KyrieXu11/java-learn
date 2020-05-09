package com.newcode_offer.二进制中1的个数;

/**
 * @author KyrieXu
 * @since 2020/4/4 22:58
 * 输入一个整数，输出该数二进制表示中1的个数。
 * 其中负数用补码表示。
 **/
public class s01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.NumberOf1(3));
        //int i = 0x80000000;
        //System.out.println(i);
    }
}

class Solution {
    /**
     * 将一个整数减去1，再和原来的整数进行与运算
     * 就会把最右边的1变成0
     * 所以要统计1的个数只需要计算有多少次这种操作就行
     *
     * @param n 整数
     * @return 1的个数
     */
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }
}
