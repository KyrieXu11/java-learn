package com.Test;

/**
 * @author KyrieXu
 * @since 2020/3/8 20:14
 **/
public class ThreadTest {
        /*
         使用了wait()之后，线程进入阻塞状态，释放同步监视器
         而sleep方法是不会释放同步监视器的
          sleep和wait方法的异同点：
          相同点：都会将线程置为阻塞态
          不同点： (1)sleep()声明在Thread类中，而wait()声明在Object类中
                  (2)sleep()可以在任意场景中调用，而wait()只能在同步代码块中调用
                  (3)如果两个方法都使用在同步代码块中，sleep()不会释放同步监视器
                      而wait()会自动释放同步监视器
        */
    public static void main(String[] args) {
        new Thread(() -> {
        }).start();
    }
}

class D01 {
    public static int num = 0;

    public static synchronized void add() throws InterruptedException {
    }
}
