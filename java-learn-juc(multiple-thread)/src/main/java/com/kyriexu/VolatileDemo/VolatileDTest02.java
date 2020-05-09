package com.kyriexu.VolatileDemo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author KyrieXu
 * @since 2020/3/8 19:33
 * 所谓的原子性就是不可分割，而在线程中来说的话就是
 * 一个线程在执行过程中，不能被打扰
 * Volatile 是 Java 虚拟机提供轻量级的同步机制
 * * 1、保证可见性 详情见 VolatileDTest01
 * * 2、不保证原子性 每次的运行结果都不是确定的2000，就说明一个线程在运行的时候被其他的线程给干扰了
 *      如果想要解决这个问题的话，可以使用 synchronized 和 lock 锁
 * * 3、禁止指令重排 详情见 VolatileDTest03
 **/
public class VolatileDTest02 {
    private static volatile int num = 0;

    public static void add() {
        num++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    add();
                }
            }).start();
        }
        while (Thread.activeCount() > 2) { // main gc
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + " " + num); // 有时候2000，但是不稳定
    }
}

class Solution{
    // 设置原子整数，并且设置初始值为 0
    private static AtomicInteger num = new AtomicInteger(0);

    public static void add(){
        // num++
        // 最终都是调用 Unsafe 类的 native 方法 native 关键字就表明是调用了 c++ 的一些函数
        num.incrementAndGet();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    add();
                }
            }).start();
        }
        while (Thread.activeCount() > 2) { // main gc
            Thread.yield();
        }
        // 确定 2000
        System.out.println(Thread.currentThread().getName() + " " + num);
    }
}




class Solution02{
    private static int num = 0;

    // 使用同步锁解决原子性问题
    public static synchronized void add() {
        num++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    add();
                }
            }).start();
        }
        while (Thread.activeCount() > 2) { // main gc
            Thread.yield();
        }
        // 确定 2000
        System.out.println(Thread.currentThread().getName() + " " + num);
    }
}

class Solution03{
    private static int num = 0;

    private static Lock lock = new ReentrantLock();

    // 使用 Lock 锁解决原子性问题
    public static void add() {
        lock.lock();
        num++;
        lock.unlock();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    add();
                }
            }).start();
        }
        while (Thread.activeCount() > 2) { // main gc
            Thread.yield();
        }
        // 确定 2000
        System.out.println(Thread.currentThread().getName() + " " + num);
    }
}