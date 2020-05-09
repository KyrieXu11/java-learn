package com.DesignMode.PrototypeMode.ShallowClone;

import java.util.Date;

/**
 * @author KyrieXu
 * @date 2020/1/22 13:59
 * 客户端类
 **/


public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date date=new Date();
        Video v1=new Video("K",date);
        System.out.println(v1);
        System.out.println("v1的地址："+v1.hashCode());

//        通过克隆v1，新建出一个v2对象
        Video v2 = (Video) v1.clone();

        System.out.println(v2);
        System.out.println("v2的地址："+v2.hashCode());

        System.out.println("=============由于是浅克隆，v1和v2都指向了同一个date对象，将date对象改变了之后，v2也会同步更新===========");

        date.setTime(12312312);
        System.out.println("v1"+v1);
        System.out.println("v2"+v2);
    }
}
