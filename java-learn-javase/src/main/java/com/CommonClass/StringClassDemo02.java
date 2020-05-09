package com.CommonClass;

/**
 * @author KyrieXu
 * @date 2020/1/27 17:24
 **/
public class StringClassDemo02 {

    String str= "123";
    char[] c={'1','2','3'};

    public static void main(String[] args) {
        StringClassDemo02 s=new StringClassDemo02();
        s.change(s.str,s.c);
        System.out.println(s.str);  // 123
        System.out.println(s.c);    // 423
    }

    public void change(String str,char[] ch){
        str="345";
        ch[0]='4';
    }

}

