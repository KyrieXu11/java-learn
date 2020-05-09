package com.realques.AutoPilot01;

import java.util.Scanner;

/**
 * @author KyrieXu
 * @since 2020/4/8 15:08
 *
 * 假设我们将地图抽象成一个N x N的二维矩阵，0为可行驶道路1为障碍物，
 * 车辆只能一步步按东、南、西、北方向行驶，
 * 请输出从A点[0,0]至B点[n-1,n-1]的最少步数（移动一次计一步）。
 *
 * 输入
 * 一共n行，每行n个整数（空格分隔），只可能为0或1
 *
 * 样例输入
 * 0 1 0 0
 *
 * 0 0 0 1
 *
 * 1 0 1 0
 *
 * 0 0 0 0
 *
 * 输出
 * 输出最短距离步数，不可到达则输出-1
 *
 * 样例输出
 * 6
 **/
public class Main {
    private static int minLen = 0;
    private static int tmp = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split(" ");
        int n = nums.length;
        // n * n 的矩阵
        int[] array = new int[n * n];
        int i = 0;
        for (String num : nums) {
            array[i++] = Integer.parseInt(num);
        }
        // 由于上面已经输入了一行了，所以就减去一行
        // 输入测试通过
        for (int j = 0; j < n - 1; j++) {
            for (int k = 0; k < n; k++) {
                array[i++] = scanner.nextInt();
            }
        }
        Search(array, 0, 0, n);
        System.out.println(minLen != 0 ? minLen : -1);
    }

    public static void Search(int[] array, int row, int col, int n) {
        if (row < 0 || col < 0 || array == null || row >= n || col >= n)
            return;
        if (row == n - 1 && col == n - 1) {
            if (minLen > tmp)
                minLen = tmp;
            if (minLen == 0)
                minLen = tmp;
            return;
        }
        if (array[row * n + col] == 0) {
            array[row * n + col] = 1;
            tmp++;
            Search(array, row, col + 1, n);
            Search(array, row + 1, col, n);
            Search(array, row, col - 1, n);
            Search(array, row - 1, col, n);
            tmp--;
            array[row * n + col] = 0;
        }
    }
}
