package com.DesignMode.AbstracFactoryMode;

public class ApplePhone implements IPhoneProduct {
    @Override
    public void start() {
        System.out.println("开启苹果手机");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭苹果手机");
    }

    @Override
    public void callup() {
        System.out.println("苹果发短信");
    }

    @Override
    public void sendMessage() {
        System.out.println("苹果发短信");
    }
}
