package com.common.sort;

import java.util.Arrays;

class Solution {
    /**
     * 快速排序的入口方法
     *
     * @param array 数组
     * @param low   数组最左的下标
     * @param high  数组最右的小标
     */
    public void QuickSort(int[] array, int low, int high) {
        if (low < high) {
            int index = getIndex(array, low, high);
            QuickSort(array, low, index - 1);
            QuickSort(array, index + 1, high);
        }
    }

    /**
     * 快速排序的功能方法
     *
     * @param array 数组
     * @param low   数组最左的下标
     * @param high  数组最右的小标
     * @return 数组大小数交界的下标
     */
    private int getIndex(int[] array, int low, int high) {
        // 基准元素
        int flag = array[low];
        while (low < high) {
            // 在数组右边一直找比基准元素大的元素，找不到了就退出循环
            while (array[high] >= flag && low < high)
                high--;
            // 将小于基准元素的元素都赋值给low指针指向的元素
            array[low] = array[high];
            // 在数组左边找比基准元素小的元素，找不到就退出循环
            while (array[low] <= flag && low < high)
                low++;
            // 将大于基准元素的元素赋值给high指针指向的元素
            array[high] = array[low];
        }
        // 大小数字交汇，将基准元素赋值给当前的low和high一同指向的元素
        array[low] = flag;
        // 返回大数字和小数字交界的下标
        return low;
    }

    /**
     * 归并排序的非递归解法(有bug待修复)
     *
     * @param array 数组
     * @param low   低位
     * @param high  高位
     */
    public void MergeSort1(int[] array, int low, int high) {
        // TODO:修复bug
        // 如果传进来的结束位置比数组的长度还要大的时候
        // 就让这个结束的位置变成数组长度
        if (high > array.length - 1)
            high = array.length - 1;
        // 几个几个一组排序
        // left是每个不同size的子元素的最开始的元素
        // size就是分组的大小
        // mid就是两个分组相交的位置
        int size = 1, mid, left;
        // 子数组的size不能超过数组的长度
        while (size < array.length) {
            // 每次循环的时候都得让left重置为数组开始位置
            left = low;
            // 看遍历分组是否遍历到array结束了
            while (left + size < array.length) {
                // 这里的mid是两个相同size的相邻的子数组
                mid = left + size - 1;
                // 合并两个
                Merge(array, low, mid, high);
                left = high + 1;
            }
            size *= 2;
        }
    }

    public int binarySearch(int[] array, int k) {
        return binarySearchCore(array, k, 0, array.length);
    }

    private int binarySearchCore(int[] array, int k, int low, int high) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (array[mid] > k)
            return binarySearchCore(array, k, low, mid - 1);
        else if (array[mid] < k)
            return binarySearchCore(array, k, mid+1, high);
        else
            return mid;
    }


    /**
     * 自顶向下的归并排序(递归)
     *
     * @param array 数组
     * @param low   数组起始位置
     * @param high  数组的结束位置
     */
    public void MergeSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            MergeSort(array, low, mid);
            MergeSort(array, mid + 1, high);
            Merge(array, low, mid, high);
        }
    }

    /**
     * 归并排序的合并方法
     *
     * @param array 数组
     * @param low   起始位置
     * @param mid   中点位置
     * @param high  结束位置
     */
    private void Merge(int[] array, int low, int mid, int high) {
        // 左闭右开区间复制的
        int[] left = Arrays.copyOfRange(array, low, mid + 1);
        int[] right = Arrays.copyOfRange(array, mid + 1, high + 1);
        // i是指向低数组的指针
        // j是指向高数组的指针
        // k是指向array的指针，后面要把上面两个子数组的元素复制给array就要用k计数
        int i = 0, j = 0, k = low;
        for (; i < left.length && j < right.length; ) {
            // 比较两个数组的数，谁小就放进array
            if (left[i] > right[j]) {
                array[k++] = right[j];
                j++;
            }
            else {
                array[k++] = left[i];
                i++;
            }
        }
        // 防止上面的两个子数组长度不一样，一个数组遍历完了，另一个数组还没遍历完
        while (i < left.length)
            array[k++] = left[i++];
        while (j < right.length)
            array[k++] = right[j++];
    }

    /**
     * 遍历数组的方法
     *
     * @param array 泛型数组
     */
    private void PrintArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1)
                System.out.print(",");
        }
        System.out.println();
    }

    /**
     * 选择排序
     *
     * @param array 数组
     */
    public void SelectSort(int[] array) {
        int length = array.length;
        // 数组的长度
        for (int i = 0; i < length; i++) {
            // 设置最小的元素的下标是第 i 个元素
            int min = i;
            // 因为前i个都是已经排好序的
            // 所以从第 i+1 个元素开始找最小的元素
            for (int j = i + 1; j < length; j++) {
                // 找到比最小的元素还要小的元素
                if (array[j] < array[min])
                    // 将min改成最小元素的下标
                    min = j;
            }
            // 如果最小的元素不是最开始的那个元素
            // 交换位置
            if (min != i) {
                int tmp = array[i];
                array[i] = array[min];
                array[min] = tmp;
            }
            PrintArray(array);
        }
    }

    /**
     * 插入排序
     *
     * @param array 数组
     */
    public void InsertArray(int[] array) {
        int length = array.length;
        // 选择的待插入的元素是第一个开始
        for (int i = 1; i < length; i++) {
            // 待排序的元素
            int waitToSort = array[i];
            // 排好序的数组的最后一个位置
            int j = i - 1;
            // 遍历排好序的元素
            for (; j >= 0; j--) {
                // 如果待排序的元素比排好序的元素
                // 从后往前比较都要大的话，就退出
                if (waitToSort > array[j])
                    break;
                // 否则向后移动元素
                array[j + 1] = array[j];
            }
            // 现在的情况应该是有比当前的数字大的数字
            array[j + 1] = waitToSort;
            PrintArray(array);
        }
    }

    /**
     * 希尔排序，就是应对插入排序在数据量大的时候性能不足的情况
     *
     * @param array 数组
     */
    public void HillSort(int[] array) {
        int length = array.length;
        int size = 1;
        // 计算希尔值
        while (size < length / 3)
            size = 3 * size + 1;
        // 当希尔值大于等于1的时候循环
        while (size >= 1) {
            // 下面的就是插入排序，只不过将插入排序的范围扩大了
            for (int i = size; i < length; i++) {
                int waitToSort = array[i];
                int j = i - size;
                for (; j >= size && waitToSort < array[j]; j -= size) {
                    array[j] = array[j - size];
                }
                array[j] = waitToSort;
            }
            size /= 3;
            PrintArray(array);
        }
    }

    public void HeapSort(int[] array) {
        int len = array.length;
        // 构建最大堆
        buildMaxHeap(array);
        for (int i = len - 1; i > 0; i--) {
            swap(array, 0, i);
            len--;
            heapify(array, 0, len);
        }
    }

    private void buildMaxHeap(int[] array) {
        int len = array.length;
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(array, i, len);
        }
    }

    private void heapify(int[] array, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        // 最大的数字下标就是i
        int largest = i;

        if (left < len && array[left] > array[largest]) {
            largest = left;
        }

        if (right < len && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(array, i, largest);
            heapify(array, largest, len);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}