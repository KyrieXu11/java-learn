package com.common.sort;

/**
 * @author KyrieXu
 * @since 2020/3/22 10:03
 **/
public class QuickSort {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] array = new int[]{23, 46, 0, 8, 11, 18};
        s.QuickSort(array, 0, array.length - 1);
        //s.PrintArray(array);
    }
}


