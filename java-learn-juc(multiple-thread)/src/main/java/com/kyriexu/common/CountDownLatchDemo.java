package com.kyriexu.common;

import java.util.concurrent.*;

/**
 * @author KyrieXu
 * @since 2020/3/6 17:04
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService tp = new ThreadPoolExecutor(8, Runtime.getRuntime().availableProcessors(), 100, TimeUnit.SECONDS, new LinkedBlockingDeque<>(6),Thread::new, new  ThreadPoolExecutor.DiscardOldestPolicy());
        CountDownLatch countDownLatch=new CountDownLatch(6);
        for (int i = 0; i < 10; i++) {
            tp.execute(()->{
                System.out.println(countDownLatch.toString());
                countDownLatch.countDown();  // 减减
            });
        }
        countDownLatch.await(); // 等countdownlatch变成0了就继续运行
        System.out.println("结束");
        tp.shutdown();
        /*
            java.util.concurrent.CountDownLatch@2181517d[Count = 6]
            java.util.concurrent.CountDownLatch@2181517d[Count = 6]
            java.util.concurrent.CountDownLatch@2181517d[Count = 6]
            java.util.concurrent.CountDownLatch@2181517d[Count = 3]
            java.util.concurrent.CountDownLatch@2181517d[Count = 2]
            java.util.concurrent.CountDownLatch@2181517d[Count = 3]
            java.util.concurrent.CountDownLatch@2181517d[Count = 3]
            结束
            java.util.concurrent.CountDownLatch@2181517d[Count = 0]
            java.util.concurrent.CountDownLatch@2181517d[Count = 0]
            java.util.concurrent.CountDownLatch@2181517d[Count = 0]
         */
        // 上面的这么一大堆是上面程序的运行结果，不是每次确定，只不过想说
        // 当countdownlatch一变成0的时候，马上就会执行await后面的语句，不会跟你多BB
    }
}
