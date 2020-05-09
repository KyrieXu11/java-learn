package com.kyriexu.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author KyrieXu
 * @since 2020/3/15 12:39
        **/
public class CasDemo01 {

    public static void main(String[] args) {
        // 乐观锁的实现，首先给一个初始的值，再给一个 版本号
        // 每次修改的时候看版本号是否变动
        AtomicStampedReference<Integer> atom = new AtomicStampedReference<>(1,1);
        // cas
        // 参数依次是：期望值，新值，期望版本，新版本
        boolean b = atom.compareAndSet(1, 2, 1, 3);
        System.out.println(atom.getStamp());
    }
}
