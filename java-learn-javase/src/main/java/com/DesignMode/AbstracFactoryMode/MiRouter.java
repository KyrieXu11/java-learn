package com.DesignMode.AbstracFactoryMode;

public class MiRouter implements IRouterProduct {
    @Override
    public void start() {
        System.out.println("开启小米路由器");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭小米路由器");
    }

    @Override
    public void setting() {
        System.out.println("开启小米路由器的设置");
    }

    @Override
    public void openWifi() {
        System.out.println("开启小米路由器的wifi");
    }
}
