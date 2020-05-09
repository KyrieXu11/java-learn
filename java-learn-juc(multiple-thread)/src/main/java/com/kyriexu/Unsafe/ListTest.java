package com.kyriexu.Unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author KyrieXu
 * @date 2020/2/19 13:40
 * 报 ConcurrentModificationException ，表明arraylist线程不安全
 **/
public class ListTest {
    public static void main(String[] args) {
        /*
            解决线程不安全的问题的解决方案是：
            1. 使用Vector，太古老了被pass掉
            2. 使用Collections.synchronizedList(new ArrayList<>())
            3. 使用JUC(java.util.concurrent):List<T> list=new CopyOnWriteArrayList<T>()
            第三种相较于第一种方法的区别在于，Vector是使用synchronized关键字，而CopyOnWriteArrayList使用的是Lock
            机制就是写入时复制，list在读的时候时固定的，写入的时候复制一份，写完时放回去再创建，读写分离，避免覆盖造成数据问题
         */
//        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        List<Integer> list=new CopyOnWriteArrayList<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                list.add(123);
                System.out.println(list);
            }).start();
        }
    }
}






//        输出列表得到快速方法
//        List<String> list= Arrays.asList("123","234");
//        list.forEach(System.out::println);
