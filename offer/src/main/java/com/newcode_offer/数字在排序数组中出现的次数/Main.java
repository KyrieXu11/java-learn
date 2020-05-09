package com.newcode_offer.数字在排序数组中出现的次数;

/**
 * @author KyrieXu
 * @since 2020/5/3 9:30
 **/
public class Main {
    public static void main(String[] args) {

    }

    public static int GetNumberOfK(int[] array, int k) {
        int cnt=0;
        for(int num: array){
            if(num==k)
                cnt++;
        }
        return cnt;
    }

}
