package com.leetcode_offer.到n整数中1出现的次数_43;

/**
 * @author KyrieXu
 * @since 2020/6/3 13:29
 **/
public class Main {
    public static void main(String[] args) {
        System.out.println(countDigitOne(824883294));
    }

    public static int countDigitOne1(int n) {
        int res = 0, cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
            ++cnt;
            if (cnt == 5) {
                for (int j = 0; j < sb.length(); j++) {
                    if (sb.charAt(j) == '1') {
                        res++;
                    }
                }
                sb = new StringBuilder();
                cnt = 0;
            }
        }
        if (cnt>0){
            for (int j = 0; j < sb.length(); j++) {
                if (sb.charAt(j) == '1') {
                    res++;
                }
            }
        }
        return res;
    }

    public static int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while(high != 0 || cur != 0) {
            if(cur == 0) res += high * digit;
            else if(cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
