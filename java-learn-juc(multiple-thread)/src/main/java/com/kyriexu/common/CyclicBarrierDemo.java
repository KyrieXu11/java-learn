package com.kyriexu.common;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author KyrieXu
 * @since 2020/3/6 17:14
 **/
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        // 加法计数器
        CyclicBarrier cyclicBarrier = new CyclicBarrier(8, () -> System.out.println("我踮踮脚"));
        //ExecutorService tp = new ThreadPoolExecutor(8, Runtime.getRuntime().availableProcessors(), 100, TimeUnit.SECONDS, new LinkedBlockingDeque<>(6),Thread::new, new  ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 0; i < 8; i++) {
            final int tmp = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "---->" + tmp);
                try {
                    // 等待
                    cyclicBarrier.await();
                }
                catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}
