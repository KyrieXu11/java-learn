package com.reflection;

import java.util.Arrays;

/**
 * @author KyrieXu
 * @date 2020/1/19 11:49
 **/
public class test05main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> test = Class.forName("root.reflection.Test05");
        Object o = test.newInstance();
        Test05 o1 = (Test05) o;
        System.out.println(o1);
    }
}
