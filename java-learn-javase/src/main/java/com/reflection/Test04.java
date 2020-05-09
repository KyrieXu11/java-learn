package com.reflection;

public class Test04 {
    public static void main(String[] args) {
//        A0 a = new A0();
        System.out.println(A0.m);
    }
}

class A0{
    static {
//        m=300;
        System.out.println("A的静态代码块被初始化");
    }

//    引用常量的时候，类不会被加载
    static final int m = 100;

    public A0(){
        System.out.println("A的无参构造器被初始化");
    }
}
