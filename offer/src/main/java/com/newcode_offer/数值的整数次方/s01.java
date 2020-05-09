package com.newcode_offer.数值的整数次方;

/**
 * @author KyrieXu
 * @since 2020/4/5 11:14
 *
 * 给定一个double类型的浮点数 base 和int类型的整数 exponent。
 * 求base的exponent次方。
 *
 * 保证base和exponent不同时为0
 **/
public class s01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

class Solution{
    public double Power(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    public double Power1(double base, int exponent) {

        return 1.0;
    }
}