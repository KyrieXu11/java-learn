package com.leetcode.不同路径_2_63;

/**
 * @author KyrieXu
 * @since 2020/4/26 9:23
 **/
public class Main {
    public static void main(String[] args) {
        int[][] array = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(uniquePathsWithObstacles(array));
    }


    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0)
            return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = 0;
                else {
                    // 在入口有障碍物.....
                    if (i == 0 && j == 0) dp[i][j] = 1;
                    else if (i == 0) dp[i][j] = dp[i][j - 1];
                    else if (j == 0) dp[i][j] = dp[i - 1][j];
                        // 之前相邻的格子走法的总和就是当前格子走法的总和
                    else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
