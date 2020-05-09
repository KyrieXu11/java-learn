package com.newcode_offer.数组中的逆序对;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author KyrieXu
 * @since 2020/4/28 14:18
 **/
public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407, 416, 366, 315, 301, 601, 650, 418, 355, 460, 505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181, 486, 149, 588, 233, 144, 174, 557, 67, 746, 550, 474, 162, 268, 142, 463, 221, 882, 576, 604, 739, 288, 569, 256, 936, 275, 401, 497, 82, 935, 983, 583, 523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870, 259, 655, 446, 863, 735, 784, 3, 671, 433, 630, 425, 930, 64, 266, 235, 187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575};
        System.out.println(InversePairs(array));
    }

    /**
     * 主要的算法思想就是利用排序后的位置之差
     * 1,2,3,4,5,7,0 排序之后的元素是 0,1,2,3,4,5,6,7
     * 因此只需要看排序后的第一个元素在原来数组中的位置前面有几个数就行了
     * 超时了
     *
     * @param array
     * @return
     */
    public static int InversePairs1(int[] array) {
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        List<Integer> l2 = Arrays.stream(array).boxed().sorted().collect(Collectors.toList());
        int cnt = 0;
        for (int i = 0; i < l2.size(); i++) {
            cnt += list.indexOf(l2.get(i));
            list.remove(l2.get(i));
        }
        return cnt % 1000000007;
    }

    public static int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return InversePairsCore(array, copy, 0, array.length - 1);
    }

    private static int InversePairsCore(int[] array, int[] copy, int low, int high) {
        if (low == high) {
            return 0;
        }
        int mid = (low + high) >> 1;
        int leftCount = InversePairsCore(array, copy, low, mid);
        int rightCount = InversePairsCore(array, copy, mid + 1, high);
        int count = 0;
        //  两个指针分别指向两个数组的最后一个元素
        int i = mid;
        int j = high;
        // 辅助数组的指针，从后往前
        int locCopy = high;
        while (i >= low && j > mid) {
            // 如果前面的数组元素大于后面的数组元素
            // 表示有 j - mid 个逆序对
            if (array[i] > array[j]) {
                count += j - mid;
                copy[locCopy--] = array[i--];
                //数值过大求余
                if (count >= 1000000007) {
                    count %= 1000000007;
                }
            }
            else {
                copy[locCopy--] = array[j--];
            }
        }
        for (; i >= low; i--) {
            copy[locCopy--] = array[i];
        }
        for (; j > mid; j--) {
            copy[locCopy--] = array[j];
        }
        if (high + 1 - low >= 0)
            System.arraycopy(copy, low, array, low, high + 1 - low);
        return (leftCount + rightCount + count) % 1000000007;
    }


}
