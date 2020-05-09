package com.newcode_offer.顺时针打印矩阵;

import java.util.ArrayList;

/**
 * @author KyrieXu
 * @since 2020/4/11 13:10
 **/
public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = j;
            }
        }
        ArrayList<Integer> list = printMatrix(matrix);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i != list.size() - 1)
                System.out.print(",");
        }
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix==null)
            return null;
        // 设定好长度，防止扩容废空间
        ArrayList<Integer> list = new ArrayList<>(matrix.length * matrix[0].length);
        // 数组的边界,因为后面需要表示数组的位置，所以减去1
        int rows = matrix.length - 1, columns = matrix[0].length - 1;
        if (rows==0||columns==0)
            return null;
        // 数组的起始值
        int left = 0, top = 0;
        while (top <= rows && left <= columns) {
            // 向右打印
            for (int i = left; i <= columns; i++)
                list.add(matrix[top][i]);
            // 向下打印
            for (int i = top + 1; i <= rows; i++)
                list.add(matrix[i][columns]);
            // 向左打印
            for (int i = columns - 1; i >= left && top < rows; i--)
                list.add(matrix[rows][i]);
            // 向上打印
            for (int i = rows - 1; i > top && left < columns; i--)
                list.add(matrix[i][left]);
            ++left;
            ++top;
            --rows;
            --columns;
        }
        return list;
    }
}
