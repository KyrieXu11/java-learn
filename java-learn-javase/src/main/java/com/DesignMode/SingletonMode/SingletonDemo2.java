package com.DesignMode.SingletonMode;

public class SingletonDemo2 {
//    步骤还是和饿汉式一样
//    1.创建私有构造器
    private SingletonDemo2() {
    }
//    2.类初始化的时候不加载对象，即不new对象出来，等到用的时候再加载对象
    private static SingletonDemo2 instance;
//    3.创建获取实例的方法,这里要设置synchronized，因为如果有多个线程进来的话，instance不安全，但是牺牲了运行效率
    public static synchronized SingletonDemo2 getInstance(){
        if(instance==null){
            instance=new SingletonDemo2();
        }
        return instance;
    }
}

class SingletonDemoTest{
    public static void main(String[] args) {
//        创建实例
        SingletonDemo2 singletonDemo2 = SingletonDemo2.getInstance();
        SingletonDemo2 singletonDemo21 = SingletonDemo2.getInstance();
//        输出的结果也是true
        System.out.println(singletonDemo2==singletonDemo21);

    }
}
