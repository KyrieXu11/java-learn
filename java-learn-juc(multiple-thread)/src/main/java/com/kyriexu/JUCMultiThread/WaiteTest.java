package com.kyriexu.JUCMultiThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author KyrieXu
 * @since 2020/3/17 22:38
 **/
public class WaiteTest {
    /*

        下面的结果是：
        B C D E F G H I A A 1 B 2 I 3 H 4 G 5 F 6 E 7 D 8 C 9
        wait()释放了锁，最后等着线程A进入调用notifyall方法
        把正在wait状态的线程唤醒
        可是结果显示所有的线程不是一下子全部唤醒的，而是单线程的唤醒
        一次只有一个线程拿到锁，所以结果才会递增
        为什么是线程同步的呢？不是使用了notifyall吗
        这篇博客说的挺好的
        https://www.jianshu.com/p/25e243850bd2?appinstall=0

        这篇博客说的很精简：
        https://blog.csdn.net/meism5/article/details/90238268

     */



    public static void main(String[] args) {
        Func f = new Func();
        new Thread(f::m1,"B").start();
        new Thread(f::m1,"C").start();
        new Thread(f::m1,"D").start();
        new Thread(f::m1,"E").start();
        new Thread(f::m1,"F").start();
        new Thread(f::m1,"G").start();
        new Thread(f::m1,"H").start();
        new Thread(f::m1,"I").start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
                f.m1();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();
    }
}

class Func{
    private AtomicInteger atom = new AtomicInteger(1);
    public int count = 0;

    public synchronized void m1(){
        try {
            System.out.println(Thread.currentThread().getName());
            if (!"A".equals(Thread.currentThread().getName())){
                wait();
            }
            notifyAll();
            System.out.println(Thread.currentThread().getName());
            count++;
            System.out.println(count);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
