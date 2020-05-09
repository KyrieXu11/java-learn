package com.realques.真题02;

import java.util.Scanner;

/**
 * @author KyrieXu
 * @since 2020/4/9 19:45
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i]=scanner.nextInt();
        }
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[i]=scanner.nextInt();
        }
        solution(A,B);
    }

    public static void solution(int[] A,int[] B){
        int[] count=new int[A.length+1];
        int[] record = new int[A.length];
        int cnt=0;
        for (int i = 0; i < A.length-1; i++) {
            count[A[i]]=getIndex(A,A[i]);
        }
        for (int i = 0; i < B.length; i++) {
            int index = getIndex(B, B[i]);
            record[i]=index-count[B[i]];
        }
        for (int i = 0; i < record.length; i++) {
            if (record[i]>0)
                cnt++;

        }
        System.out.println(cnt);
    }

    private static int getIndex(int[] a,int b){
        for (int i = 0; i < a.length; i++) {
            if (b==a[i])
                return i;
        }
        return -1;
    }
}
