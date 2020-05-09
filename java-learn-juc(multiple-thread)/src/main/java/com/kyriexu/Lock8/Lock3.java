package com.kyriexu.Lock8;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * @author KyrieXu
 * @date 2020/2/19 13:25
 * 结果还是1. 发短信 2. 打电话，因为加了static的synchronized方法是锁的class对象
 **/
public class Lock3 {
    public static void main(String[] args) {
        new Thread(Phone2::Msg,"A").start();
        new Thread(Phone2::Call,"B").start();
    }
}

class Phone2{

    //    锁的是方法的调用者
    @SneakyThrows
    public static synchronized void Msg(){
        TimeUnit.SECONDS.sleep(2);
        System.out.println("发短信");
    }

    public static synchronized void Call(){
        System.out.println("打电话");
    }
}

