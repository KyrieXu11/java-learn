package com.DesignMode.PrototypeMode.DeepClone;

import java.util.Date;

/**
 * @author KyrieXu
 * @date 2020/1/22 14:28
 **/
public class DClient {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date date=new Date();
        DVideo v1=new DVideo("123",date);
        DVideo v2 = (DVideo) v1.clone();
        System.out.println(v1);
        System.out.println(v2);
        date.setTime(21312312);
        System.out.println(v1);
        System.out.println(v2);

    }
}
