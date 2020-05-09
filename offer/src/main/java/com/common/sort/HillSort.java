package com.common.sort;

/**
 * @author KyrieXu
 * @since 2020/4/7 23:08
 **/
public class HillSort {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array={49,38,65,97,76,13,27,49,78,34,12,64,1};
        solution.HillSort(array);
        //solution.PrintArray(array);
    }
}
