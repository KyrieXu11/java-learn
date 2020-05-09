package com.newcode_offer.斐波那契数列;

/**
 * @author KyrieXu
 * @since 2020/4/4 21:15
 **/
public class s01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.Fibonacci(5));
        System.out.println(solution.Fibonacci1(5));
    }
}

class Solution{
    public int Fibonacci(int n) {
        if (n==0||n==1)
            return n;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    public int Fibonacci1(int n){
        if (n<2)
            return n==1?1:0;
        int fib1=1,fib2=0;
        int res=0;
        for (int i = 0; i <= n - 2; i++) {
            res=fib1+fib2;
            fib2=fib1;
            fib1=res;
        }
        return res;
    }
}
