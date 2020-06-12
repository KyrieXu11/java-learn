package com.kyriexu.VolatileDemo;

import java.util.concurrent.TimeUnit;

/**
 * @author KyrieXu
 * @since 2020/3/8 18:48
 * 因为主各个线程之间不知道num已经变了，所以还在死循环当中
 * 这就是程序可见性
 * 所以要将num声明为 volatile 才能让各个线程都可见
 * Volatile 是 Java 虚拟机提供轻量级的同步机制
 * 1、保证可见性 这个例子就说明了保证可见性
 * 2、不保证原子性 详情见 VolatileDTest02
 * 3、禁止指令重排 详情见 VolatileDTest03
 **/
public class VolatileDTest01 {

    private static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (num == 0) {

            }
        }).start();
        TimeUnit.SECONDS.sleep(2);
        num = 1;
        System.out.println("主线程的：" + num);

    }
}
