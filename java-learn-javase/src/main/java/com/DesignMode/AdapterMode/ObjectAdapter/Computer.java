package com.DesignMode.AdapterMode.ObjectAdapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author KyrieXu
 * @date 2020/2/16 16:33
 * 对象适配器模式是比类适配器模式高级的
 * 使用组合的方式调整适配器能够热拔插式的上网
 **/
public class Computer {
    public void Net(Target net) {
        net.Transform();
    }

    public static void main(String[] args) {
        // 创建电脑
        Computer computer = new Computer();
        //  创建网线，并且可以创建不同的网线
        Adaptee adaptee = new Adaptee("网线1");
        Adaptee adaptee1 = new Adaptee("网线2");
        //  创建适配器，插上网线
        Adapter adapter = new Adapter(adaptee);
        // 上网
        computer.Net(adapter);
        //  拔了原来的网线，插上新网线
        adapter.setAdaptee(adaptee1);
        // 上网
        computer.Net(adapter);
    }

}

// 适配目标
interface Target {
    void Transform();
}

@Data
@AllArgsConstructor
@NoArgsConstructor
// 适配器
class Adapter implements Target {
    private Adaptee adaptee;

    @Override
    public void Transform() {
        adaptee.request();
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
// 适配对象
class Adaptee {
    private String name = "网线";

    public void request() {
        System.out.println("连接" + name + "上网");
    }
}

