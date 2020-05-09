package com.realques.空间回廊;

import java.util.Scanner;

/**
 * @author KyrieXu
 * @since 2020/4/8 19:03
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 房间数
        int n = scanner.nextInt();
        // 法力值
        int m = scanner.nextInt();
        int[] array = new int[n];
        // 循环输入每个房间的法力值
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        solution(array, n, m);
    }

    public static void solution(int[] array, int n, int m) {
        int res = 0;
        while (true) {
            // 标志所有的房间的是否可以留下烙印
            // 如果为n的话表示所有房间都不能被留下烙印
            int quit = 0;
            for (int i = 0; i < n; i++) {
                // 减去法力
                m = m - array[i];
                // 如果差值大于0，烙印加1
                if (m >= 0)
                    res++;
                else
                    quit++;
            }
            // 全部不能留下烙印，退出
            if (quit == n)
                break;
        }
        System.out.println(res);
    }
}
