package com.kyriexu.cas;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author KyrieXu
 * @since 2020/3/15 13:30
 *
 * 解决ABA问题
 * 所谓的ABA问题就是：
 *  假设有个线程A去判断账户里的钱此时是15，满足条件，直接+20，这时候卡里余额是35.
 *  但是此时不巧，正好在连锁店里，这个客人正在消费，又消费了20，此时卡里余额又为15，
 *  线程B去执行扫描账户的时候，发现它又小于20，又用过cas给它加了20
 *  这样的话就相当于加了两次，这样循环往复肯定把老板的钱就坑没了！
 *
 *  所以要记录修改的次数(版本)才能避免上面的ABA问题
 **/
public class OptimisticLock {
    public static void main(String[] args) {
        // 设置一个初始值
        AtomicStampedReference<Integer> stamp = new AtomicStampedReference<>(1,1);
        new Thread(()->{
            int version = stamp.getStamp();
            System.out.println(Thread.currentThread().getName()+" "+version);

            // 修改值
            boolean b = stamp.compareAndSet(1, 2, 1, version + 1);
            System.out.println(Thread.currentThread().getName()+" "+b+" "+stamp.getReference() );

            // 修改回来
            b = stamp.compareAndSet(2, 1, stamp.getStamp(), stamp.getStamp() + 1);
            System.out.println(Thread.currentThread().getName()+" "+b);


        },"A").start();

        new Thread(()->{
            int version = stamp.getStamp();
            System.out.println(Thread.currentThread().getName()+" "+version);

            // 修改值
            boolean b = stamp.compareAndSet(1, 9, 1, version + 1);
            System.out.println(Thread.currentThread().getName()+" "+b+" "+stamp.getReference() );

            //// 修改回来
            //b = stamp.compareAndSet(2, 1, stamp.getStamp(), stamp.getStamp() + 1);
            //System.out.println(Thread.currentThread().getName()+" "+b);


        },"B").start();


    }
}
