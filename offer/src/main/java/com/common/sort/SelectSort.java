package com.common.sort;

/**
 * @author KyrieXu
 * @since 2020/4/7 20:13
 **/
public class SelectSort {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[]{3,4,1,2,5,10,8,9};
        solution.SelectSort(array);
        //solution.PrintArray(array);
    }
}
