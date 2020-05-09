package com.realques.分配订单;

import java.util.Scanner;

/**
 * @author KyrieXu
 * @since 2020/4/9 14:29
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] mark = new double[n*n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mark[i*n+j]=scanner.nextDouble();
            }
        }
    }
    
}
