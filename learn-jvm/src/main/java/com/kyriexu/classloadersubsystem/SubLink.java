package com.kyriexu.classloadersubsystem;

/**
 * @author KyrieXu
 * @since 2020/3/17 15:53
 **/
public class SubLink {
    public static int a = 1;

    public final static int c = 10;


    static {
        a = 3;
        b = 2;
    }

    public static int b = 1;

    public static void main(String[] args) {
        System.out.println(SubLink.a); // a=3
        System.out.println(SubLink.b); // b=1
        String str = "hello";

    }
}
