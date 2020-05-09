package com.DesignMode.FactoryMode.Method;

public class Main {
    public static void main(String[] args) {
        Car car1=new BMWFactory().getCar();
        Car car2=new TeslaFactory().getCar();
        car1.name();
        car2.name();
    }
}
