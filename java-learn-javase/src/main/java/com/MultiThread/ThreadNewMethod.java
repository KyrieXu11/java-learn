package com.MultiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author KyrieXu
 * @date 2020/1/27 12:35
 **/
public class ThreadNewMethod {
    public static void main(String[] args) {
        /*
        创建callable线程的步骤
            1. 实现Callable接口，实现call()方法，返回值可以返回随便的值
            2. 创建FutureTask对象，因为FutureTask实现了Runnable接口，所以可以创建线程
            3. 使用Thread类创建线程，并且运行，如果需要call()的返回值，可以使用task.get()来获取
         */
        FutureTask task=new FutureTask(new Number());
        new Thread(task).start();
    }
}

/*
    相较于Runnable接口，Callable接口的优势：
        1. 可以有返回值
        2. 可以抛出异常
        3. Callable支持泛型：这里的返回值是整形，可以指定Callable的泛型为Integer
            同时FutureTask也要指定泛型
 */

class Number implements Callable{
    @Override
    public Object call() throws Exception {
        int sum=0;
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println("sum："+sum);
                sum+=i;
            }
        }
        return null;
    }
}
