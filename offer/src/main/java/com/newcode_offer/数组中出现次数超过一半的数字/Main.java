package com.newcode_offer.数组中出现次数超过一半的数字;

/**
 * @author KyrieXu
 * @since 2020/4/25 13:16
 **/
public class Main {


    public static void main(String[] args) {
        int[] array=new int[]{1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(array));
    }

    public static int MoreThanHalfNum_Solution(int[] array) {
        int[] index = new int[100000];
        int len = array.length;
        for (int i : array) {
            index[i]++;
            if (index[i] > len / 2)
                return i;
        }
        return 0;
    }
}
