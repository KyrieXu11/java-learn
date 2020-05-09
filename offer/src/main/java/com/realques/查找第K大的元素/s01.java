package com.realques.查找第K大的元素;

import java.util.Arrays;

/**
 * @author KyrieXu
 * @since 2020/3/22 9:29
 **/
public class s01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array=new int[]{23,46,0,8,11,18};
        System.out.println(solution.getNum(array, 3));
    }
}

class Solution{

    public int getNum(int[] array,int n){
        // 先排序
        quicksort(array,0,array.length-1);
        // 再找
        return array[n-1];
    }


    private void quicksort(int[] array,int low,int high){
        if (low<high){
            int left = index(array, low, high);
            quicksort(array,low,left-1);
            quicksort(array,left+1,high);
        }
    }

    private int index(int[] array,int low,int high){
        // 基准元素
        int flag = array[low];
        while (low<high){
            // 在数组右边一直找比基准元素大的元素，找不到了就退出循环
            while (array[high]>=flag&&low<high)
                high--;
            // 将小于基准元素的元素都赋值给low指针指向的元素
            array[low]=array[high];
            // 在数组左边找比基准元素小的元素，找不到就退出循环
            while (array[low]<=flag&&low<high)
                low++;
            // 将大于基准元素的元素赋值给high指针指向的元素
            array[high]=array[low];
        }
        // 大小数字交汇，将基准元素赋值给当前的low和high一同指向的元素
        array[low]=flag;
        // 返回大数字和小数字交界的下标
        return low;
    }
}
