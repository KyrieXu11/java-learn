package com.newcode_offer.用两个栈实现队列;

import java.util.Stack;

/**
 * @author KyrieXu
 * @since 2020/3/21 23:33
 **/
public class s01 {
    public static void main(String[] args) {
        Soluition s = new Soluition();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.pop());
        s.push(4);
        System.out.println(s.pop());
        s.push(5);
        System.out.println(s.pop());
    }
}

class Soluition{
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        int size = stack2.size();
        for (int i = 0; i < size; i++) {
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        int size = stack1.size();
        for (int i = 0; i < size; i++) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
