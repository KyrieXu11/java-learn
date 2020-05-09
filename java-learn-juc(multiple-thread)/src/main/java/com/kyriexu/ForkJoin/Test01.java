package com.kyriexu.ForkJoin;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @author KyrieXu
 * @since 2020/3/8 14:13
 **/
public class Test01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        forkTest();
        streamTest();
    }

    // 使用forkjoin来算
    public static void forkTest() throws ExecutionException, InterruptedException {
        // 东8区的时间,获取秒数
        long startTime = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> fork = new ForkDemo01(0L,40_0000_0000L,1000L);
        // 提交任务
        ForkJoinTask<Long> submit = pool.submit(fork);
        Long res = submit.get();
        long endTime = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println("和为： "+res+"时间消耗是："+(endTime-startTime));
    }

    // 使用并行流来计算
    public static void streamTest(){
        long startTime = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).getEpochSecond();
        // 左开右闭区间
        long res = LongStream.rangeClosed(0L, 40_0000_0000L).parallel().sum();
        long endTime = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).getEpochSecond();
        System.out.println("和为： "+res+"时间消耗是："+(endTime-startTime));
    }

}
