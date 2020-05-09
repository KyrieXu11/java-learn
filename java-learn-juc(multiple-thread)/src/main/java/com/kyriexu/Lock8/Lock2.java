package com.kyriexu.Lock8;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * @author KyrieXu
 * @date 2020/2/19 12:39
 * 因为是两把锁，所以都可以执行，因为Call方法没有延迟，所以先执行
 **/
public class Lock2 {
    public static void main(String[] args) {
        Phone1 phone=new Phone1();
        Phone1 phone1=new Phone1();
        new Thread(phone::Msg,"A").start();
        new Thread(phone1::Call,"B").start();
    }
}

class Phone1{

    //    锁的是方法的调用者
    @SneakyThrows
    public synchronized void Msg(){
        TimeUnit.SECONDS.sleep(2);
        System.out.println("发短信");
    }

    public synchronized void Call(){
        System.out.println("打电话");
    }
}

