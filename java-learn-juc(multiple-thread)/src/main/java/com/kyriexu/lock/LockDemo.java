package com.kyriexu.lock;

import java.util.Random;

/**
 * @author KyrieXu
 * @since 2020/3/15 11:40
 **/
public class LockDemo {
    public static void main(String[] args) {
        L l = new L();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int flag = r.nextInt(2);
            if (flag == 0)
                new Thread(l::M1, String.valueOf(i)).start();
            else
                new Thread(l::M2, String.valueOf(i)).start();

        }
    }
}

class L {
    // 可重入锁就是得到了大门的钥匙里面的房间的锁就开了
    public synchronized void M1() {
        System.out.println(Thread.currentThread().getName() + " 进入m1");
        M2();
    }

    public synchronized void M2() {
        System.out.println(Thread.currentThread().getName() + " 进入m2");
    }
}
