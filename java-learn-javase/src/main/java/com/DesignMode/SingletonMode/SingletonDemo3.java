package com.DesignMode.SingletonMode;

//DCL懒汉式
//双重检测
public class SingletonDemo3 {
//    步骤还是和饿汉式一样
//    1.创建私有构造器
    private SingletonDemo3() {
    }
    //    2.类初始化的时候不加载对象，即不new对象出来，等到用的时候再加载对象
    private static SingletonDemo3 instance;
    //    3.创建获取实例的方法,使用同步代码块的方式，效率比单纯的懒汉式高
    public static SingletonDemo3 getInstance(){
        if(instance==null){
//        如果很多线程进来之后，争抢这个锁
            synchronized (SingletonDemo3.class){
//                如果有一个线程抢到了锁，如果该线程没有创建过实例，那么就创建，如果创建过了，那就释放掉锁，使用别的线程创建的实例
                if(instance==null){
                    instance = new SingletonDemo3();
                }
            }
        }
        return instance;
    }
}

class SingletonDemoTest3{
    public static void main(String[] args) {
//        创建实例
        SingletonDemo3 instance1 = SingletonDemo3.getInstance();
        SingletonDemo3 instance2 = SingletonDemo3.getInstance();
//        输出的结果也是true
        System.out.println(instance1==instance2);

    }
}
