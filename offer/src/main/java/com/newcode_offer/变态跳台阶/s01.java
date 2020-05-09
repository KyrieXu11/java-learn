package com.newcode_offer.变态跳台阶;

/**
 * @author KyrieXu
 * @since 2020/4/4 22:44
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 **/
public class s01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.JumpFloorII(1));
    }
}

class Solution{
    public int JumpFloorII(int target) {
        return (int) Math.pow(2,target-1);
    }
}
