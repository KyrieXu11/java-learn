package com.kyriexu.threadlocal;

/**
 * @author KyrieXu
 * @since 2020/3/28 20:52
 **/
public class ThreadLocalTest {

    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            final int tmp = i;
            new Thread(()->{
                threadLocal.set(tmp);
                System.out.printf("%s,%s\n",Thread.currentThread().getName(),threadLocal.get());
            },i+"").start();

        }
    }
}
