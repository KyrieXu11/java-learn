package com.Test;

import org.junit.Test;

/**
 * @author KyrieXu
 * @date 2020/2/21 16:10
 **/
public class StringTest {
    public static void main(String[] args) {

    }

    public StringBuilder sb1=new StringBuilder("1");
    public StringBuilder sb2=new StringBuilder("2");

    @Test
    public void Test01(){
        StringBuffer a=new StringBuffer("A");
        StringBuffer b=new StringBuffer("B");
        change(a,b);
        System.out.println(a.hashCode()+" "+b.hashCode()); // 911312317 415186196
        System.out.println(a+""+b);
        StringTest str=new StringTest();
        change(str.sb1,str.sb2);
        System.out.println(str.sb1+" "+str.sb2);

    }

    public void change(StringBuffer x,StringBuffer y){
        x.append(y);
        System.out.println(x.hashCode());   // 911312317
        System.out.println(y.hashCode());   // 415186196
        y=x;    // y=x是让y指向了x，但是b还是指向y这个单元，没有指向x这个单元
        System.out.println(x.hashCode());   // 911312317
        System.out.println(y.hashCode());   // 911312317
        System.out.println(y);
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
}
