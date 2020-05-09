package com.DesignMode.FactoryMode.Method;

public class TeslaFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new Tesla();
    }
}
