package com.leetcode.和为K的子数组_560;

import java.util.HashMap;
import java.util.Map;

/**
 * @author KyrieXu
 * @since 2020/5/1 10:36
 **/
public class Main {
    public int subarraySum(int[] nums, int k) {
        int cnt = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            // 大致的想法就是如果map中有sum-k对应的 答案的话
            // 就+1
            if (map.containsKey(sum - k))
                cnt += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}
