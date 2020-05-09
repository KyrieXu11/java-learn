package com.realques.表达式求值;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author KyrieXu
 * @since 2020/4/9 9:18
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();
        String[] str = s.split(" ");
        if (str[str.length - 1].equals("and") || str[str.length - 1].equals("or") || str[0].equals("and") || str[0].equals("or")) {
            System.out.println("error");
            return;
        }
        if (str.length % 2 == 0) {
            System.out.println("error");
            return;
        }
        Stack<String> stack = new Stack<>();
        for (int i = str.length - 1; i >= 0; i--) {
            if (i % 2 == 0 && (str[i].equals("and") || str[i].equals("or"))) {
                System.out.println("error");
                return;
            }
            else if (i % 2 == 1 && (str[i].equals("true") || str[i].equals("false"))) {
                System.out.println("error");
                return;
            }
            else {
                String temp = str[i];
                if (temp.equals("and")) {
                    temp = stack.pop();
                    if (temp.equals("false") || str[i - 1].equals("false")) {
                        temp = "false";
                    }
                    else {
                        temp = "true";
                    }
                    stack.push(temp);
                    i--;
                }
                else {
                    stack.push(temp);
                }
            }
        }
        while (!stack.isEmpty()) {
            if (stack.pop().equals("true")) {
                System.out.println("true");
                return;
            }
        }
        System.out.println("false");
    }
}
