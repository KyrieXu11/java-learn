package com.MultiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author KyrieXu
 * @date 2020/1/27 13:04
 * 使用线程池管理多线程
 **/
public class ThreadPoolDemo {
    public static void main(String[] args) {
//        创建一个大小为10个线程的线程池
        ExecutorService service= Executors.newFixedThreadPool(10);
//        使用线程池调用实现Runnable类的方法
        service.execute(new MthreadG());
//        service.submit()适用于Callable接口
//        关闭线程池
        service.shutdown();
    }
}

class MthreadG implements Runnable{
    @Override
    public void run() {
        int sum=0;
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+"   sum："+sum);
                sum+=i;
            }
        }
    }
}
