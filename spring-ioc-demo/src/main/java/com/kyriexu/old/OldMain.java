package com.kyriexu.old;

/**
 * @author KyrieXu
 * @date 2020/2/20 20:27
 **/
public class OldMain {
    public static void main(String[] args) {
        Car car=new Car(20);
        car.run();
    }
}

class Car {

    private FrameWork frameWork;

    public Car(int size) {
        this.frameWork = new FrameWork(size);
    }
    public void run(){
        System.out.println("run");
    }
}

class FrameWork {
    private Bottom bottom;

    public FrameWork(int size) {
        this.bottom = new Bottom(size);
    }
}

class Bottom {

    private Tire tire;

    public Bottom(int size) {
        this.tire = new Tire(size);
    }
}

class Tire  {
    private int size;

    public Tire(int size) {
        this.size = size;
    }
}

