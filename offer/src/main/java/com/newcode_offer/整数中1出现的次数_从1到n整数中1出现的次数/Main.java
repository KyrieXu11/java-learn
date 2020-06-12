package com.newcode_offer.整数中1出现的次数_从1到n整数中1出现的次数;

/**
 * @author KyrieXu
 * @since 2020/4/25 15:00
 **/
public class Main {
    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(824883294));
    }

    public static int NumberOf1Between1AndN_Solution(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            cnt += containOne(i);
        }
        return cnt;
    }

    private static int containOne(int n) {
        int cnt = 0;
        while (n != 0) {
            if (n % 10 == 1)
                cnt++;
            n /= 10;
        }
        return cnt;
    }
}
