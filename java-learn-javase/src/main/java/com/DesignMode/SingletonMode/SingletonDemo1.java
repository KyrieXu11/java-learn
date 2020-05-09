package com.DesignMode.SingletonMode;

public class SingletonDemo1 {
//    1.创建私有构造器，为了防止在类外创建对象
    private SingletonDemo1() {
    }
//    2.创建静态的实例，在类初始化的时候马上加载对象,即new一个对象出来
    private static SingletonDemo1 instance = new SingletonDemo1();
//    3.获取该对象的方法，因为没有synchronized，运行效率高
    public static SingletonDemo1 getInstance(){
        return instance;
    }
}

class SingletonTest{
    public static void main(String[] args) {
//        创建两个对象，结果但是这两个对象应该是一个对象
        SingletonDemo1 singleton = SingletonDemo1.getInstance();
        SingletonDemo1 singleton1 = SingletonDemo1.getInstance();
//        验证是否为相同对象，结果是true
        System.out.println(singleton==singleton1);
    }
}
