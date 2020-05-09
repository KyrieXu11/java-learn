package com.DesignMode.AbstracFactoryMode;

public class MiPhone implements IPhoneProduct {
    @Override
    public void start() {
        System.out.println("开启小米手机");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭小米手机");
    }

    @Override
    public void callup() {
        System.out.println("小米发短信");
    }

    @Override
    public void sendMessage() {
        System.out.println("小米发短信");
    }
}
