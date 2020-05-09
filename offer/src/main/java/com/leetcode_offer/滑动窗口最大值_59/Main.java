package com.leetcode_offer.滑动窗口最大值_59;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author KyrieXu
 * @since 2020/5/3 13:34
 **/
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(nums, 3);
        List<Integer> list = Arrays.stream(res).boxed().collect(Collectors.toList());
        System.out.println(list);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0)
            return new int[0];
        int[] res = new int[nums.length-k+1];
        int cnt=0;
        for(int i=0;i<nums.length-k+1;i++){
            int num = maxNum(nums,i,i+k);
            res[cnt++]=num;
        }
        return res;
    }

    private static int maxNum(int[] array,int start,int end){
        int max=array[start];
        for(int i=start;i<end;i++){
            if(max<array[i])
                max=array[i];
        }
        return max;
    }

    // 单调队列
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if(nums.length == 0) return new int[0];
        Deque<Integer> deq = new ArrayDeque<>();
        int[] res = new int[nums.length-k+1];
        int count = 0;

        for(int i=0; i<nums.length; i++) {
            while(!deq.isEmpty() && deq.peekLast() < nums[i]) deq.pollLast();
            deq.addLast(nums[i]);

            if(i >= k-1) {
                res[count++] = deq.peekFirst();
                if(nums[i-k+1] == deq.peekFirst()) {
                    deq.pollFirst();
                }
            }
        }
        return res;
    }
}
