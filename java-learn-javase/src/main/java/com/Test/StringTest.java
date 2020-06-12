package com.Test;

import org.junit.Test;

/**
 * @author KyrieXu
 * @date 2020/2/21 16:10
 **/
public class StringTest {

    // 1、如果两个对象相等，那么他们一定有相同的哈希值（hash code）。
    //
    // 2、如果两个对象的哈希值相等，那么这两个对象有可能相等也有可能不相等。（需要再通过equals来判断）

    public static void main(String[] args) {
        String s1 = new StringBuilder("徐").toString();
        System.out.println(s1.intern()==s1);

        // "java"这个字符串已经加载过一次了
        String s = new StringBuilder("java").toString();
        // intern()会将首次出现的字符串移到常量池中
        System.out.println(s.intern()==s);
    }

    @Test
    public void Teststr2(){
        String a="a";
        String b="b";
        String c=a+b;
        System.out.println((a+b)==c);
    }


    @Test
    public void TestStr2(){
        String x="fmn";
        x.toUpperCase();
        String y=x.replace('f','F');
        y=y+"wxy";
        System.out.println(y);
    }

    @Test
    public void TestS1(){
        String a = "12";
        String c="1"+"2";
        System.out.println(a==c);
    }

    public StringBuilder sb1=new StringBuilder("1");
    public StringBuilder sb2=new StringBuilder("2");

    @Test
    public void Test01(){
        StringBuffer a=new StringBuffer("A");
        StringBuffer b=new StringBuffer("B");
        change(a,b);
        System.out.println(a.toString()+" "+b.toString());
        StringTest s = new StringTest();
        change(s.sb1,s.sb2);
        System.out.println(s.sb1+" "+s.sb2);
    }

    // x传过来的是地址，可以直接进行操作
    public void change(StringBuffer x,StringBuffer y){
        x.append(y);
        y.append(x);
       // System.out.println(y.append(x));
    }

    public void change(StringBuilder x,StringBuilder y){
        x.append(y);
        y=x;
        // 这里也是一样的
    }

    @Test
    public void TestIntToChar(){
        System.out.println(1+2+",");
    }

    @Test
    public void TestLo(){
        String a = "ASHDJOHASODI";
        a=a.toLowerCase();
        System.out.println(a);
    }

    @Test
    public void TestStringArgs(){
        String x="234";
        change(x);
        System.out.println(x);

    }

    public void change(String x){
        x="123";
    }

    @Test
    public void TestEq(){

        String s1 = new StringBuilder("计算机科学").toString();
        System.out.println(s1.intern()==s1);

        // "java"这个字符串已经加载过一次了
        String s = new StringBuilder("java").toString();
        // intern()会将首次出现的字符串移到常量池中
        System.out.println(s.intern()==s);
    }
}
