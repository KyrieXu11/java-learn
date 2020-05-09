package com.MultiThread;

/**
 * @author KyrieXu
 * @date 2020/1/26 18:41
 * 使用同步方法来解决多线程安全问题
 **/
public class ThreadDemo03 {
    public static void main(String[] args) {
        MthreadC m=new MthreadC();

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

class MthreadC implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true){
            boolean flag = sellTicket();
            if(!flag)
                break;
        }
    }

    // 锁的是对象实例
    public synchronized boolean sellTicket(){
        boolean flag=true;
        if(ticket>0){
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"："+ticket);
            ticket--;
        }else
            flag=false;
        return flag;
    }
}
