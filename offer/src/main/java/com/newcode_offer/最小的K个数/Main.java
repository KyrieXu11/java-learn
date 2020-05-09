package com.newcode_offer.最小的K个数;

import java.util.ArrayList;

/**
 * @author KyrieXu
 * @since 2020/4/25 13:26
 * <p>
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 **/
public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(GetLeastNumbers_Solution(array, 10));
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>(k);
        if (k > input.length)
            return res;
        quickSort(input, 0, input.length - 1);
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }


    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int index = getIndex(array, low, high);
            quickSort(array, low, index - 1);
            quickSort(array, index + 1, high);
        }
    }


    private static int getIndex(int[] array, int low, int high) {
        int flag = array[low];
        while (low < high) {
            while (array[high] >= flag && low < high)
                high--;
            array[low] = array[high];
            while (array[low] <= flag && low < high)
                low++;
            array[high] = array[low];
        }
        array[low] = flag;
        return low;
    }

}
