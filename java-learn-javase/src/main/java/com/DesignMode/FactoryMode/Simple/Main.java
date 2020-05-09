package com.DesignMode.FactoryMode.Simple;

public class Main {
    public static void main(String[] args) {
        Car car=CarFactory.getCar("宝马");
        assert car != null;
        car.name();
    }
}
