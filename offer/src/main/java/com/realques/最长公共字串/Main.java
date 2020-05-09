package com.realques.最长公共字串;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author KyrieXu
 * @since 2020/4/8 10:05
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next().toLowerCase();
        String s2 = scanner.next().toLowerCase();
        System.out.println("result="+getMaxLcs(s1, s2));
    }

    /**
     * 动态规划求解最长公共子串
     * 思路参考： https://blog.csdn.net/qq_25800311/article/details/81607168
     * @param s1 字符串1
     * @param s2 字符串2
     * @return 最长公共子串
     */
    public static String getMaxLcs(String s1, String s2) {
        int maxLen = 0, maxEnd = 0;
        // 动态规划数组
        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (i == 0 || j == 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else
                    dp[i][j] = 0;
                if (dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                    maxEnd = i + 1;
                }
            }
        }
        String res = s1.substring(maxEnd - maxLen, maxEnd);
        return maxEnd!=0?res:"";
    }
}
