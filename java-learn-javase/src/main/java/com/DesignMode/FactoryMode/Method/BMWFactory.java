package com.DesignMode.FactoryMode.Method;

public class BMWFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new BMW();
    }
}
