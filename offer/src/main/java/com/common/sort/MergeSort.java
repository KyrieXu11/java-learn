package com.common.sort;

/**
 * @author KyrieXu
 * @since 2020/3/22 10:10
 **/
public class MergeSort {
    public static void main(String[] args) {
        Solution s =new Solution();
        int[] array = new int[]{23, 8, 0, 46, 11, 18};
        s.MergeSort1(array,0,array.length-1);
        //s.PrintArray(array);
    }
}
