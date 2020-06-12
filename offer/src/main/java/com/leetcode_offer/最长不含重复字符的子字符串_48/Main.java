package com.leetcode_offer.最长不含重复字符的子字符串_48;

import java.util.HashMap;
import java.util.Map;

/**
 * @author KyrieXu
 * @since 2020/5/17 11:08
 **/
public class Main {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int head = 0, tail, maxLen = 0;
        for (tail = 0; tail < s.length(); tail++) {
            if (map.containsKey(s.charAt(tail)))
                head = Math.max(map.get(s.charAt(tail)), head);
            map.put(s.charAt(tail), tail + 1);
            maxLen = Math.max(maxLen, tail - head + 1);
        }
        return maxLen;
    }
}
