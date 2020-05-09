package com.kyriexu.Lock8;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * @author KyrieXu
 * @date 2020/2/19 13:28
 * 由于现在是两把锁：一把锁锁class对象，一把锁锁Phone3对象，所以谁先拿到谁先执行，因为msg延迟了4秒所以call方法先执行
 **/
public class Lock4 {
    public static void main(String[] args) {
        Phone3 phone3=new Phone3();
        new Thread(Phone3::Msg,"A").start();
        new Thread(phone3::Call,"B").start();
    }
}

class Phone3{
    //    锁的是方法的调用者
    @SneakyThrows
    public static synchronized void Msg(){
        TimeUnit.SECONDS.sleep(2);
        System.out.println("发短信");
    }

    public synchronized void Call(){
        System.out.println("打电话");
    }
}
