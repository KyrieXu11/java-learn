package com.newcode_offer.包含min函数的栈;

import java.util.Stack;

/**
 * @author KyrieXu
 * @since 2020/4/11 14:48
 **/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(123);
        solution.push(234);
        solution.push(456);
        System.out.println(solution.min());
        solution.pop();
        solution.pop();
        //solution.push(456);
        System.out.println(solution.top());
    }
}

class Solution {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int node) {
        stack.push(node);
        // 防止没有元素pop失败抛出异常
        if (min.isEmpty())
            min.push(node);
        else
            // 有元素就看进来的元素是否小于最小栈的元素
            if (node<=min.peek())
                // 如果小于，那就压栈
                min.push(node);
    }

    public void pop() {
        if (min.peek().equals(stack.peek()))
            min.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
