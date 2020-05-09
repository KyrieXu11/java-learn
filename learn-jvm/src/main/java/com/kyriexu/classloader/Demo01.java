package com.kyriexu.classloader;

/**
 * @author KyrieXu
 * @since 2020/3/16 13:17
 **/
public class Demo01 {
    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        System.out.println(demo01.getClass().getClassLoader());
        System.out.println(demo01.getClass().getClassLoader().getParent());
        System.out.println(demo01.getClass().getClassLoader().getParent().getParent());
    }
}
