package com.MultiThread;

/**
 * @author KyrieXu
 * @date 2020/1/26 17:31
 * 实现Runnable接口，存在线程安全问题
 **/
public class ThreadDemo01 {
    public static void main(String[] args) {
        MthreadA a=new MthreadA();

        Thread aT = new Thread(a);
        Thread bT = new Thread(a);

        aT.setName("线程1");
        bT.setName("线程2");

        bT.start();
        aT.start();

    }
}

class MthreadA implements Runnable {
    private int ticket = 1000;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName()+":"+ticket);
                ticket--;
            }else
                break;
        }
    }
}
