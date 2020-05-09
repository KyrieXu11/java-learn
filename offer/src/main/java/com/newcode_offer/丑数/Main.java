package com.newcode_offer.丑数;

/**
 * @author KyrieXu
 * @since 2020/4/28 12:25
 **/
public class Main {
    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(1500));
    }

    public static int GetUglyNumber_Solution(int index) {
        if (index <= 0)
            return 0;
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        // 下一个丑数的位置
        int nextUglyNum = 1, ug2 = 0, ug3 = 0, ug5 = 0;
        while (nextUglyNum < index) {
            int min = minInt(uglyNumbers[ug2] * 2, uglyNumbers[ug3] * 3, uglyNumbers[ug5] * 5);
            uglyNumbers[nextUglyNum] = min;
            if (uglyNumbers[nextUglyNum] == uglyNumbers[ug2] * 2)
                ug2++;
            if (uglyNumbers[nextUglyNum] == uglyNumbers[ug3] * 3)
                ug3++;
            if (uglyNumbers[nextUglyNum] == uglyNumbers[ug5] * 5)
                ug5++;
            ++nextUglyNum;
        }
        return uglyNumbers[index - 1];
    }

    private static int minInt(int a, int b, int c) {
        int min = Math.min(a, b);
        return Math.min(min, c);
    }

    public static int GetUglyNumber_Solution1(int index) {
        int cnt = 0, num = 1;
        while (cnt < index) {
            if (isUglyNum(num))
                cnt++;
            num++;
        }
        return num;
    }

    private static boolean isUglyNum(int n) {
        while (n % 2 == 0)
            n /= 2;
        while (n % 5 == 0)
            n /= 5;
        while (n % 3 == 0)
            n /= 3;
        return n == 1;
    }
}
