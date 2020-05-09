package com.DesignMode.FacadeMode;

/**
 * @author KyrieXu
 * @since 2020/3/11 22:17
 **/
public class FacadePattern01 {
    public static void main(String[] args) {
        ShapeFacade facade = new ShapeFacade();
        facade.drawCircle();
        facade.drawSquare();
    }
}

// 定义形状的接口
interface Shape{
    void draw();
}

// 一个圆
class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("画一个圆");
    }
}

// 一个正方形
class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("画一个正方形");
    }
}

// 形状的门面，就是相当于做一个工厂和代理的感觉
class ShapeFacade{
    private Shape circle;
    private Shape square;

    public ShapeFacade() {
        this.circle = new Circle();
        this.square = new Square();
    }

    public void drawCircle(){
        circle.draw();
    }

    public void drawSquare(){
        square.draw();
    }
}

