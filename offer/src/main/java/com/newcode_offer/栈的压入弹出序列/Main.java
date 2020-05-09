package com.newcode_offer.栈的压入弹出序列;

import java.util.Stack;

/**
 * @author KyrieXu
 * @since 2020/4/20 9:30
 **/
public class Main {
    public static void main(String[] args) {
        int[] pushA = new int[]{1, 2, 3, 4, 5};
        int[] popA = new int[]{4, 5, 3, 2, 1};
        System.out.println(IsPopOrder(pushA, popA));
    }


    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            for (; j < popA.length && stack.peek() == popA[j]; j++) {
                stack.pop();
            }
        }
        return stack.empty();
    }
}
