package com.kyriexu.JUCMultiThread;

/**
 * @author KyrieXu
 * @date 2020/2/19 10:49
 **/
public class JUCProducerConsumer {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    data.inc();
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    data.dec();
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    data.inc();
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C").start();
    }
}


class Data {
    private int num = 0;

    public synchronized void inc() throws InterruptedException {
//        if(num!=0) 这里如果使用if的话，只会判断一次，在大于2个线程的情况之下，会产生虚假唤醒问题
//        虚假唤醒就是 https://www.cnblogs.com/tqyysm/articles/9765667.html 在这篇文章中写的挺好
//        简单的说一下，就是：
//        A 从队列拿了一个元素，这个时候B也想拿，但是队列是空的，B就进入阻塞状态，然后C放了一个东西到队列里面，把B叫醒了
//        然后A刚好做完任务，而且抢到了锁，所以A就把东西给抢了，这个时候B醒了，但是队列还是空的，B就一直等


//        因为if只会判断1次，所以必须使用while才能保证不会出现虚假唤醒的问题
        while (num != 0) {
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName() + "---->" + num);
        this.notifyAll();
    }


    public synchronized void dec() throws InterruptedException {
//        这里使用while的原因同上
        while (num == 0) {
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName() + "---->" + num);
        this.notifyAll();
    }
}