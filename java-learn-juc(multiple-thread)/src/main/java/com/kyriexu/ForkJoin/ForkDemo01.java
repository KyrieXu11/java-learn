package com.kyriexu.ForkJoin;

import java.util.concurrent.RecursiveTask;

/**
 * @author KyrieXu
 * @since 2020/3/8 14:14
 * ForkJoin的原理示意图就是： https://sm.ms/image/1R2yVA8dYNuFcvZ
 * ForkJoin的特点就是工作窃取： https://sm.ms/image/edkSUlvgJBtG3fD
 * 简单来说就是两个线程执行，一个线程执行的快一些，然后快的线程帮慢的线程从后往前做
 **/
public class ForkDemo01 extends RecursiveTask<Long> {

    private Long start;

    private Long end;

    private Long standard;

    public ForkDemo01() {
    }

    public ForkDemo01(Long start, Long end, Long standard) {
        this.start = start;
        this.end = end;
        this.standard = standard;
    }

    public ForkDemo01(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        // 如果首末相差不大，那么就直接使用for循环计算
        if ((end - start) < standard) {
            long sum = 0L;
            for (long i = start; i < end; i++) {
                sum += i;
            }
            return sum;
        }
        else {
            long mid = (start + end) / 2;
            // 采用分治的思想
            ForkDemo01 fork = new ForkDemo01(start, mid,standard);
            fork.fork(); // 将任务压入线程队列
            ForkDemo01 fork2 = new ForkDemo01(mid + 1, end,standard);
            fork2.fork(); // 将任务压入线程队列
            // Returns the result of the computation when it isDone
            // 返回计算结果
            return fork.join()+fork2.join();
        }
    }
}
