package com.newcode_offer.旋转数组的最小数字;

/**
 * @author KyrieXu
 * @since 2020/3/22 1:16
 **/
public class s01 {
    public static void main(String[] args) {
        Solution s= new Solution();
        int[] array = new int[]{};
        System.out.println(s.minNumberInRotateArray(array));
    }
}

class Solution{
    public int minNumberInRotateArray(int [] array) {
        if (array.length==0)
            return 0;
        // 设置两个指针
        int low=0,high= array.length-1;
        // 循环查找
        while (low<high){
            // 中位数
            int mid = (low+high)/2;
            // 如果中间的比高位的数字都要大，那么肯定是在 中间到高位 这段区间寻找
            if (array[mid]>array[high])
                low=mid+1;
            // 如果是 中间比高位 的低的话，那么就在 低到中间 这段区间寻找
            else if (array[mid]<array[high])
                high=mid;
            else
                // 否则只能一个一个遍历寻找
                high=high-1;
        }
        return array[low];
    }
}
