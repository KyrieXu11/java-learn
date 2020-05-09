package com.MultiThread;

/**
 * @author KyrieXu
 * @date 2020/1/26 18:59
 **/
public class ThreadDemo04 {
    public static void main(String[] args) {
//        MthreadD t1=new MthreadD();
//        MthreadD t2=new MthreadD();
//        MthreadD t3=new MthreadD();
//
//        t1.setName("线程1");
//        t2.setName("线程1");
//        t3.setName("线程1");
//
//        t1.start();
//        t2.start();
//        t3.start();
        MthreadE t1=new MthreadE();
        MthreadE t2=new MthreadE();
        MthreadE t3=new MthreadE();

        t1.setName("线程1");
        t2.setName("线程1");
        t3.setName("线程1");

        t1.start();
        t2.start();
        t3.start();


    }
}

class MthreadD extends Thread{

    private static int ticket=100;

    @Override
    public void run() {
        while (true){
            synchronized (MthreadD.class){
                if (ticket > 0) {
                    try {
                        sleep(100);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(currentThread().getName() + "：" + ticket);
                    ticket--;
                }
                else
                    break;
            }
        }
    }
}

class MthreadE extends Thread{

    private static int ticket=100;

    @Override
    public void run() {
        while (true){
            boolean flag = sellTicket();
            if(!flag)
                break;
        }
    }

//    这里要加上static,因为同步监视器必须是同一个对象,如果是static的话,那么这个对象就是这个类的class对象
    private static synchronized boolean sellTicket(){
        boolean flag=true;
        if(ticket>0){
            try {
                sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(currentThread().getName()+"："+ticket);
            ticket--;
        }else
            flag=false;
        return flag;
    }

}
