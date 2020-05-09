package com.kyriexu.Lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author KyrieXu
 * @date 2020/2/19 13:31
 **/
public class Lock5 {
    public static void main(String[] args) {
        Phone4 phone4 = new Phone4();
        new Thread(() -> {
            try {
                phone4.Call();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(phone4::Msg).start();
        // 有锁和没锁的方法还是谁先能够抢到cpu谁先执行,和普通的两个无锁的方法执行顺序差不多
        // 不过因为在同等的条件下，有锁的方法是会执行的慢一些的，所以一般是无锁的方法先执行
    }
}

class Phone4 {
    private int a = 1;

    public synchronized void Msg() {
        System.out.println("发短信");
    }

    public void Call() throws InterruptedException {
        //a--;
        // 如果这个后面输出a的话，就会发短信在前面先执行
        // 原因就是输出要比线程创建执行要慢
        //TimeUnit.SECONDS.sleep(2);
        System.out.println("打电话" );
    }

    public void Game() {
        a++;
        System.out.println("玩游戏" + a);
    }
}

