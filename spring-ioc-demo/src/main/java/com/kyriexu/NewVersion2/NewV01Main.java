package com.kyriexu.NewVersion2;

/**
 * @author KyrieXu
 * @date 2020/2/20 20:55
 **/
public class NewV01Main {
    public static void main(String[] args) {
        int size=30;
        Car car=new Car();
        FrameWork frameWork=new FrameWork();
        Bottom bottom=new Bottom();
        Tire tire=new Tire();
        tire.setSize(size);
        bottom.setTire(tire);
        frameWork.setBottom(bottom);
        car.setFrameWork(frameWork);
        car.run();
    }
}

class Car {

    private FrameWork frameWork;


    public void setFrameWork(FrameWork frameWork) {
        this.frameWork = frameWork;
    }

    public void run(){
        System.out.println("run");
    }
}

class FrameWork {
    private Bottom bottom;

    public void setBottom(Bottom bottom) {
        this.bottom = bottom;
    }

}

class Bottom {

    private Tire tire;

    public void setTire(Tire tire) {
        this.tire = tire;
    }

}

class Tire  {
    private int size;

    public void setSize(int size) {
        this.size = size;
    }

}