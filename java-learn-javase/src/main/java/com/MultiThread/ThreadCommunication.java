package com.MultiThread;

/**
 * @author KyrieXu
 * @date 2020/1/27 11:24
 * 线程通信的例子，notify()和wait()
 * 两个线程交替打印0到100的数字
 **/
public class ThreadCommunication {
    public static void main(String[] args) {
        MthreadF m = new MthreadF();

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

class MthreadF implements Runnable {
    private int number = 0;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                /*
                  notify()和wait()要写在同步代码块中
                  如果有多个阻塞态的线程的话，优先唤醒优先级高的线程
                  notifyAll()是唤醒所有阻塞态的线程的方法
                 */
                notifyAll();
                if (number <= 100) {
                    try {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "：" + number);
                    number++;
                    try {
                        /*
                           使用了wait()之后，线程进入阻塞状态，释放同步监视器
                           而sleep方法是不会释放同步监视器的
                            sleep和wait方法的异同点：
                            相同点：都会将线程置为阻塞态
                            不同点： (1)sleep()声明在Thread类中，而wait()声明在Object类中
                                    (2)sleep()可以在任意场景中调用，而wait()只能在同步代码块中调用
                                    (3)如果两个方法都使用在同步代码块中，sleep()不会释放同步监视器
                                            而wait()会自动释放同步监视器
                         */
                        wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else
                    break;
            }
        }
    }
}
