package com.Test;

import org.junit.Test;

/**
 * @author KyrieXu
 * @date 2020/2/21 16:04
 **/
public class BaseTest {
    @Test
    public void Test01() {
        /*
            1、整数类型byte（1个字节）short（2个字节）int（4个字节）long（8个字节）
            2、字符类型char（2个字节）
            3、浮点类型float（4个字节）double（8个字节）
            默认是double型的数字，如果要是float的话得在后面加上一个f
         */
        float a = 123.0f;

        int c=1,b=1;
//        false在后面的话进if就会改变值，如果false在前面的话就不会改变c值
        if(false&&(c=b << 1)==0) {
            System.out.println("branchA");
        }
        System.out.println(c);
    }

    static int[] num = new int[5];

    /*
            在Java中，变量有两种类型，一种是原始类型，一种是引用类型。
            原始类型一共有8种，它们分别是char,boolean,byte,short,int,long,float,double。在Java API中，有它们对应的包装类，分别是(首字母大写)Character,Boolean,Byte,Short,Integer,Long,Float,Double(char,int的变化稍微大点)。
            JAVA JVM对于不同的原始类型会分配不同的存储空间，具体分配如下：
            byte  : 1个字节    8位
            最大值: 127   (有符号)
            short : 2个字节    16位                            32767
            int :     4个字节    32位                            2147483647
            long:   8个字节    64位                            9223372036854775807
            float:   4个字节    32位                            3.4028235E38
            double:8个字节   64位                            1.7976931348623157E308
            枚举（enum）类型是Java 5新增的特性，它是一种新的类型，允许用常量来表示特定的数据片断，而且全部都以类型安全的形式来表示，是特殊的类，可以拥有成员变量和方法。

     */


    // 默认输出0
    public static void main(String[] args) {
        System.out.println(num[4]);
    }

    @Test
    public void baseTest01(){
        char a=123;
        System.out.print(a);
    }

    @Test
    public void test02(){
        int n=3-1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println(n);
    }
}

interface It {
    abstract void show();
}