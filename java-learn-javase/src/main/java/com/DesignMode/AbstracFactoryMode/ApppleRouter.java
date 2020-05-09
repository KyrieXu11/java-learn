package com.DesignMode.AbstracFactoryMode;

public class ApppleRouter implements IRouterProduct {
    @Override
    public void start() {
        System.out.println("开启苹果路由器");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭苹果路由器");
    }

    @Override
    public void setting() {
        System.out.println("开启苹果路由器的设置");
    }

    @Override
    public void openWifi() {
        System.out.println("开启苹果路由器的wifi");
    }
}
