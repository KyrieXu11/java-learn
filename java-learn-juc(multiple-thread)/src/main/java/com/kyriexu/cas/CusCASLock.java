package com.kyriexu.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author KyrieXu
 * @since 2020/3/15 13:59
 **/
public class CusCASLock {
    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            Lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"正在运行");
                TimeUnit.SECONDS.sleep(2);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                // 一定要解锁
                Lock.unlock();
            }
        },"A").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            Lock.lock();
            System.out.println(Thread.currentThread().getName()+"正在运行");
            Lock.unlock();
        },"B").start();
    }
}

class Lock{
    private static AtomicReference<Thread> atom = new AtomicReference<>();

    public static void lock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"上锁！");
        // 自旋锁
        // 如果线程非空，则让他变成空的，其他的线程就一直在这自旋
        while (!atom.compareAndSet(null,thread)){
        }
    }

    public static void unlock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"解锁！");
        // 解锁就不用自旋了，不然锁和解锁的都是自旋锁，导致所有线程一直自旋
        atom.compareAndSet(thread,null);
    }
}
