package com.MultiThread;

/**
 * @author KyrieXu
 * @date 2020/1/26 19:40
 **/
public class ThreadDemo05 {
    public static void main(String[] args) {

        StringBuffer s1=new StringBuffer();
        StringBuffer s2=new StringBuffer();

        new Thread(() -> {
            synchronized (s1){
                s1.append('c');
                s2.append("1");
                synchronized (s2){
                    s1.append("d");
                    s2.append("2");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (s2){
                s1.append('a');
                s2.append("2");
                synchronized (s1){
                    s1.append('b');
                    s2.append("1");
                }
            }
        }).start();
        System.out.println(s1);
        System.out.println(s2);

    }
}
