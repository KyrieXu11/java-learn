package com.leetcode_offer.二维数组中的查找_04;

/**
 * @author KyrieXu
 * @since 2020/6/6 11:23
 **/
public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(findNumberIn2DArray(matrix, 20));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int j = col - 1, i = 0;
        while (i < row&&j>=0) {
            if (matrix[i][j] > target)
                --j;
            else if (matrix[i][j] < target)
                ++i;
            else if (matrix[i][j] == target)
                return true;
        }
        return false;
    }
}
