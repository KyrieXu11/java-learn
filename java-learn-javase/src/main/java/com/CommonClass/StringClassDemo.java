package com.CommonClass;

import org.junit.Test;

/**
 * @author KyrieXu
 * @date 2020/1/27 13:17
 **/
public class StringClassDemo {

    @Test
    public void StringDemo01() {
        /*
           1. String类声明为final的表明，String类无法被继承
           2. String 实现了 Comparable和 Serializable 接口
           3. 不可变的字符序列 主要体现在于，常量池不会存储两个相同的字符串
                1. 当重新给字符串赋值的时候，需要重新指定内存地址，不能使用原来的内存
                2. 当在原有的字符串的基础上拼接一个字符串时
        */
        String s1 = "abc";    //  这种方式叫做字面量赋值方式
        String s2 = "abc";

        System.out.println(s1==s2); //  true
        System.out.println("s1的内存地址：" + s1.hashCode());
        System.out.println("s2的内存地址：" + s2.hashCode());

        s1 = "hello";
        System.out.println("赋值 hello 之后s1的内存地址：" + s1.hashCode());
        System.out.println("hello 的内存地址：" + "hello".hashCode());
        System.out.println("---------------------------------------------");

        s2 += "def";
        System.out.println("s2拼接def之后的内存地址：" + s2.hashCode());
        System.out.println("---------------------------------------------");

        String s3 = s2.replace('a', 'm');
        System.out.println("s2：" + s2.hashCode());
        System.out.println("s3：" + s3.hashCode());


    }

    @Test
    public void StringDemo02() {
        //此时的字符串存储在字符串常量池中
        String s1 = "abc";
        String s2 = "abc";
        //此时s2保存的地址值是数据在堆空间开辟空间之后的地址值
        String s3 = new String("abc");
        String s4 = new String("abc");
        System.out.println(s1 == s2);   // true
        System.out.println(s1 == s3);   // false
        System.out.println(s3 == s4);   // false
        System.out.println("---------------------------------------------");

        Person p1=new Person("小明");
        Person p2=new Person("小明");


        //因为在构造方法赋值的时候采用的方式是字面量赋值，所以结果是true,存在了常量区里面
        System.out.println(p1.getName()==p2.getName()); // true
    }

    @Test
    public void StringAppendTest(){
        /*
            只要有变量参与的都相当于new一个 string 对象
         */
        String s1="abc";
        String s2="def";
        String s3="abcdef";
        String s4="abc"+"def";
        String s5=s1+"def";
        String s6="abc"+s2;

        System.out.println(s3==s4); // true
        System.out.println(s3==s5); // false
        System.out.println(s3==s6); // false
        System.out.println(s5==s6); // false

        //此时的s8是存放在常量区中的字符串
        String s8=s5.intern();
        System.out.println(s3==s8); // true

        String s9=" abc ";
        //结果是false说明，使用了方法之后是不存放在常量池中的
        System.out.println(s1==s9.trim());  //  false
    }

}

class Person{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
