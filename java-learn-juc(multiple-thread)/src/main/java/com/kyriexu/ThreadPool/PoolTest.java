package com.kyriexu.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author KyrieXu
 * @since 2020/3/5 18:09
 * 普通的创建线程池的三个方法
 **/
public class PoolTest {
    public static void main(String[] args) {
        // 创建单个线程的线程池
        ExecutorService te1 = Executors.newSingleThreadExecutor();

        //  固定的线程池
        ExecutorService te2 = Executors.newScheduledThreadPool(5);

        // 可变的线程池
        ExecutorService te3 = Executors.newCachedThreadPool();
        /*
            说一下上面的创建线程的坏处吧：
                1. 1 和 2 这两种方式创建的线程池，允许的最大请求是Integer.MAX_VALUE，可能会堆积大量的请求，导致 OOM
                2. 3 这种方式呢，允许创建的线程池大小是 Integer.MAX_VALUE ， 所以可能堆积大量的线程，导致 OOM

                因为有上面的这几种原因，所以才要自己手动使用原生的创建线程池的方式来创建 详情请看 PoolTest2
         */
        //startThread(te1);
        //startThread(te2);
        //startThread(te3);
        te1.shutdown();
        te2.shutdown();
        te3.shutdown();
    }

    private static void startThread(ExecutorService threadPool) {
        for (int i = 0; i < 100; i++) {
            final int temp = i;
            // 使用线程池来创建线程
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "-->" + temp);
            });
        }
        threadPool.shutdown();
    }
}
