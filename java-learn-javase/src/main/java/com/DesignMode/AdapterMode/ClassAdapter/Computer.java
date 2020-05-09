package com.DesignMode.AdapterMode.ClassAdapter;

/**
 * @author KyrieXu
 * @since 2020/3/11 14:14
 **/
public class Computer {
    public void net(Adapter adapter){
        adapter.Transform();
    }

    public static void main(String[] args) {
        // 创建电脑
        Computer computer=new Computer();
        // 创建适配器
        Adapter adapter=new Adapter();
        // 上网
        computer.net(adapter);
    }
}

interface Target{
    void Transform();
}

// 适配器要同时照顾两边，所以继承和实现对应的类和接口
// 但是java是单继承的，所以一个适配器只能继承一个适配对象
class Adapter extends Adaptee implements Target{
    @Override
    public void Transform() {
        super.request();
    }
}

class Adaptee{
    public void request(){
        System.out.println("连接网线上网");
    }
}
