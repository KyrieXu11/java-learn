package com.newcode_offer.第一个只出现一次的字符;

/**
 * @author KyrieXu
 * @since 2020/4/28 13:24
 **/
public class Main {
    public static void main(String[] args) {
        String str = "google";
        System.out.println(FirstNotRepeatingChar(str));
        System.out.println(str.indexOf('l'));
    }

    public static int FirstNotRepeatingChar(String str) {
        int[] nums = new int[256];
        for (int i = 0; i < str.length(); i++) {
            nums[str.charAt(i)]++;
        }
        boolean flag = false;
        int minIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                char c = (char) i;
                if (!flag) {
                    minIndex = str.indexOf(c);
                    flag = true;
                }
                if (str.indexOf(c) < minIndex)
                    minIndex = str.indexOf(c);
            }
        }
        return minIndex;
    }
}
