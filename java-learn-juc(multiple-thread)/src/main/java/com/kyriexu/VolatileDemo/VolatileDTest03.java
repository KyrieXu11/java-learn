package com.kyriexu.VolatileDemo;

/**
 * @author KyrieXu
 * @since 2020/3/8 21:01
 *
 * Volatile 是 Java 虚拟机提供轻量级的同步机制
 * 1、保证可见性 详情见 VolatileDTest01
 * 2、不保证原子性 详情见 VolatileDTest02
 * 3、禁止指令重排 在底层实现的时候，cpu 是会按照自己认为的最佳执行顺序来执行程序的
 *          所以使用 volatile 来告诉操作系统，你别搞，让我自己决定我的执行顺序是什么
 *
 *
 *
 **/
public class VolatileDTest03 {
    public static void main(String[] args) {

    }
}
