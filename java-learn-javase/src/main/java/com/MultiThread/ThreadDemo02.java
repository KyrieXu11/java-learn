package com.MultiThread;

/**
 * @author KyrieXu
 * @date 2020/1/26 18:11
 * 利用同步锁机制，来解决线程安全问题
 **/
public class ThreadDemo02 {
    public static void main(String[] args) {
        MthreadB m = new MthreadB();

        Thread a = new Thread(m);
        Thread b = new Thread(m);
        Thread c = new Thread(m);

        a.setName("线程1");
        b.setName("线程2");
        c.setName("线程3");

        a.start();
        b.start();
        c.start();

    }
}

class MthreadB implements Runnable {

//    只使用一个对象创建多个线程的时候可以不使用static
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
//            synchronized后面的那个参数叫做同步监视器，同步监视器，必须是同一个对象
            synchronized (MthreadB.class) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "：" + ticket);
                    ticket--;
                }
                else
                    break;
            }
        }
    }
}
