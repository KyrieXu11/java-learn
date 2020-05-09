package com.MultiThread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author KyrieXu
 * @date 2020/1/27 0:11
 **/
public class ThreadLock {
    public static void main(String[] args) {
        LockT lockT=new LockT();
        Thread a = new Thread(lockT);
        Thread b = new Thread(lockT);
        Thread c = new Thread(lockT);

        a.setName("线程1");
        b.setName("线程2");
        c.setName("线程3");

        a.start();
        b.start();
        c.start();
    }
}

class LockT implements Runnable {

    private int ticket = 100;
//    中间可以有个参数，如果参数值为true的话，表明线程先进先出
//    如果是false等于不加这个参数，即不是先进先出
//    和synchronized的区别是，synchronized是自动的释放锁，而lock是自己手动释放锁
//    而相同的是都解决了线程同步的问题
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticket > 0) {
                    Thread.sleep(100);
                }
                    System.out.println(Thread.currentThread().getName() + "：" + ticket);
                    ticket--;
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }
    }
}
