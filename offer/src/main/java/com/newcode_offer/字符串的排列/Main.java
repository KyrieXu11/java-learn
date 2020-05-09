package com.newcode_offer.字符串的排列;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author KyrieXu
 * @since 2020/4/24 14:54
 **/
public class Main {
    public static void main(String[] args) {
        ArrayList<String> abc = Permutation("abc");
        System.out.println(abc);
    }


    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str.length() == 0)
            return list;
        Permutation(list, str.toCharArray(), 0);
        Collections.sort(list);
        return list;
    }

    private static void Permutation(ArrayList<String> list, char[] chars, int begin) {
        // 只剩下最后一个字符就是递归出口
        if (begin == chars.length - 1) {
            String str = String.valueOf(chars);
            if (!list.contains(str)){
                list.add(str);
                System.out.println(list);
            }
        }
        for (int i = begin; i < chars.length; i++) {
            // 第一个
            swap(chars, begin, i);
            Permutation(list, chars, begin + 1);
            swap(chars, begin, i);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
