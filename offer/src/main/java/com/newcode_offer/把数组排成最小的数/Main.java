package com.newcode_offer.把数组排成最小的数;

import java.util.*;

/**
 * @author KyrieXu
 * @since 2020/4/28 10:24
 **/
public class Main {

    protected static String minStr;

    public static void main(String[] args) {
        int[] nums = new int[]{3, 32, 321};
        System.out.println(PrintMinNumber(nums));
        System.out.println(minNumber(nums));
    }


    // 将数组中的元素排序拼接即可
    public static String minNumber(int[] nums) {
        List<String> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num + "");
        }
        Collections.sort(list, (o1, o2) -> (o1 + o2).compareTo((o2 + o1)));
        return String.join("",list);
    }

    // 这个方式比上面的方式更快一些
    public static String minNumber1(int[] nums) {
        List<String> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num + "");
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo((o2 + o1));
            }
        });
        StringBuilder sb = new StringBuilder(list.size());
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static String PrintMinNumber(int[] numbers) {
        List<String> list = new ArrayList<>();
        findMin(numbers, 0, list);
        String min = list.get(0);
        for (String s : list) {
            if (s.compareTo(min) < 0)
                min = s;
        }
        return min;
    }

    private static void findMin(int[] numbers, int begin, List<String> strs) {
        if (begin == numbers.length) {
            StringBuilder res = new StringBuilder();
            for (int number : numbers) {
                res.append(number);
            }
            String s = res.toString();
            if (!strs.contains(s))
                strs.add(s);
        }
        else {
            for (int i = 0; i < numbers.length; i++) {
                swap(numbers, i, begin);
                findMin(numbers, begin + 1, strs);
                swap(numbers, i, begin);
            }
        }
    }

    private static void findMin(int[] numbers, int begin) {
        if (begin == numbers.length) {
            StringBuilder res = new StringBuilder();
            for (int number : numbers) {
                res.append(number);
            }
            String s = res.toString();
            if (s.compareTo(minStr) < 0)
                minStr = s;
        }
        else {
            for (int i = 0; i < numbers.length; i++) {
                swap(numbers, i, begin);
                findMin(numbers, begin + 1);
                swap(numbers, i, begin);
            }
        }
    }

    private static void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }
}
