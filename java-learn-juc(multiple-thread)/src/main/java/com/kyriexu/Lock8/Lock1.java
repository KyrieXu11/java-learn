package com.kyriexu.Lock8;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * @author KyrieXu
 * @date 2020/2/19 12:03
 * 每次固定的顺序都是
 *        1. 发短信
 *        2. 打电话
 **/
public class Lock1 {
    @SneakyThrows
    public static void main(String[] args) {
        Phone phone=new Phone();
//        这个方式原来是使用lambda表达式的，idea自动简写成这样了，应该是jdk11的新特性
//        因为phone调用了Msg，所以被锁的是phone对象，A线程先拿到了phone的锁，所以先执行
        new Thread(phone::Msg,"A").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(phone::Call,"B").start();
    }
}

class Phone{

//    锁的是方法的调用者
    public synchronized void Msg(){
        System.out.println("发短信");
    }

    public synchronized void Call(){
        System.out.println("打电话");
    }
}
