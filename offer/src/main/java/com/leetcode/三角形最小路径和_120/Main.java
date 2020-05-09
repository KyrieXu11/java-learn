package com.leetcode.三角形最小路径和_120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author KyrieXu
 * @since 2020/4/30 15:43
 **/
public class Main {
    public static void main(String[] args) {
        List<Integer> list = Collections.singletonList(2);


    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> curTr = triangle.get(i);
            for (int j = 0; j < curTr.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + curTr.get(j);
            }
        }
        return dp[0][0];
    }
}
