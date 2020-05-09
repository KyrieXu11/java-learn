package com.kyriexu.ThreadPool;

import java.util.concurrent.*;

/**
 * @author KyrieXu
 * @since 2020/3/5 18:56
 **/
public class PoolTest02 {
    public static void main(String[] args) {
        /*
            int corePoolSize,   在没有任务需要执行的时候线程池的大小，如果没有设置超时时间的话会一直存在，不论是否工作
            int maximumPoolSize, 线程池的最大的线程数量
            long keepAliveTime, 如果线程数量比 核心线程数 还要多的话，这个就是停止的线程的存活时间
            TimeUnit unit,      上面存活时间的时间单位
            BlockingQueue<Runnable> workQueue   阻塞队列
            ThreadFactory threadFactory, 线程工厂：创建线程的，一般不用动
            RejectedExecutionHandler handler 拒绝策略有四种：
                DiscardOldestPolicy  丢掉最老的任务
                AbortPolicy     不处理，抛出异常
                CallerRunsPolicy  哪里调用的就回哪里
                DiscardPolicy   队列满了就丢掉新来的任务，不抛出异常


            上面的核心线程数是什么呢，就好比是食堂打饭，有几个窗口在工作就是核心的线程数
            最大的线程池数量就是 食堂的最多的窗口数量

         */
        ExecutorService tp1 = null;
        try {
            int cpuNum = Runtime.getRuntime().availableProcessors();
                /*
                    1. CPU密集型：几个cpu就设最大的线程池数量为几
                    2. IO密集型： 大于程序耗费IO资源的线程数，一般设为 2 倍
                 */
            tp1 = new ThreadPoolExecutor(cpuNum,  // 核心线程数
                    cpuNum,     // Cpu密集型，设置最大的Cpu数量
                    3, // 超时时间为3 s
                    TimeUnit.SECONDS, // 时间单位
                    new LinkedBlockingDeque<>(4),  // 阻塞队列
                    Executors.defaultThreadFactory(), // 这个是默认的创建线程的工厂
                    new ThreadPoolExecutor.AbortPolicy()); // 拒绝策略是 丢掉老的任务
            for (int i = 0; i < 100; i++) {
                final int tmp = i;
                tp1.execute(() -> System.out.println(Thread.currentThread().getName() + "--->" + tmp));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            assert tp1 != null;
            tp1.shutdown();
        }
    }
}
