package com.MultiThread;

/**
 * @author KyrieXu
 * @date 2020/1/27 12:13
 **/
public class ProduceAndConsumer {
    public static void main(String[] args) {
        Clerk clerk=new Clerk();

        Producer producer=new Producer(clerk);
        Consumer consumer=new Consumer(clerk);

        producer.setName("生产者");
        consumer.setName("消费者");

        producer.start();
        consumer.start();
    }
}

class Clerk{

    private int product=0;

//    要使用notify和wait的条件就是，两个方法在同步监视器里面
//    此时的同步监视器对象是Clerk的对象，至始至终都只创建了一个Clerk对象
    public synchronized void Produce() {
        if(product<20){
            product++;
            System.out.println(Thread.currentThread().getName()+"正在生产第"+product+"个产品");
//            每次生产都要唤醒消费者
            notify();
        }else{
            try {
//                生产超过20个就休息
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void Consumer() {
        if(product>0){
            System.out.println(Thread.currentThread().getName()+"正在消费第"+product+"个产品");
            product--;
//            消费者消费了一个产品就可以唤醒生产者
            notify();
        }else{
            try {
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true){
            try {
                sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.Produce();
        }
    }
}

class Consumer extends Thread{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true){
            try {
                sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.Consumer();
        }
    }
}
