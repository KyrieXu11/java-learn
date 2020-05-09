package com.kyriexu.NewVersion1;

/**
 * @author KyrieXu
 * @date 2020/2/20 20:55
 **/
public class NewV01Main {
    public static void main(String[] args) {
        int size=30;
        Tire tire=new Tire(size);
        Bottom bottom=new Bottom(tire);
        FrameWork frameWork=new FrameWork(bottom);
        Car car=new Car(frameWork);
        car.run();
    }
}

class Car {

    private FrameWork frameWork;

    public Car(FrameWork frameWork) {
        this.frameWork = frameWork;
    }

    public void run(){
        System.out.println("run");
    }
}

class FrameWork {
    private Bottom bottom;

    public FrameWork(Bottom bottom) {
        this.bottom = bottom;
    }
}

class Bottom {

    private Tire tire;

    public Bottom(Tire tire) {
        this.tire = tire;
    }
}

class Tire  {
    private int size;

    public Tire(int size) {
        this.size = size;
    }
}