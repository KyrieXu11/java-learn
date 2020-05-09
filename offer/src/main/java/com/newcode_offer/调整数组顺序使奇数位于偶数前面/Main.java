package com.newcode_offer.调整数组顺序使奇数位于偶数前面;

import java.util.Scanner;

/**
 * @author KyrieXu
 * @since 2020/4/10 9:19
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        reOrderArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i!=array.length-1)
                System.out.print(",");
        }
    }

    public static void reOrderArray(int[] array) {
        int[] odd = new int[array.length];
        int[] even = new int[array.length];
        int j = 0, k = 0;
        for (int value : array) {
            if (value % 2 == 0)
                even[j++] = value;
            else
                odd[k++] = value;
        }
        int m = 0;
        for (int i = 0; i < k; i++) {
            array[m++]=odd[i];
        }
        for (int i = 0; i < j; i++) {
            array[m++]=even[i];
        }
    }
}
