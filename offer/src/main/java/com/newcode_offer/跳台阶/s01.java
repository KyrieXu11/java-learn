package com.newcode_offer.跳台阶;

/**
 * @author KyrieXu
 * @since 2020/4/4 22:19
 *
 * 一只青蛙一次可以跳上1级台阶，
 * 也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 **/
public class s01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.JumpFloor(5));
    }
}

class Solution{
    /**
     * 实际上和斐波拉契数列是同根同源的
     * 将跳台阶看成第一个台阶有两种跳法，
     * 然后就变成了n-1的问题
     *
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        // 第一个台阶有两种情况
        // 要么为2要么为1
        if (target==1)
            return target;
        int fib1=1,fib2=1,res=0;
        for (int i = 0; i <= target - 2; i++) {
            res=fib1+fib2;
            fib2=fib1;
            fib1=res;
        }
        return res;
    }
}
