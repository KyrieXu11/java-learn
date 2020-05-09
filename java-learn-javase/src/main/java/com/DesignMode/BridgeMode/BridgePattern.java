package com.DesignMode.BridgeMode;

/**
 * @author KyrieXu
 * @since 2020/3/11 21:57
 **/
public class BridgePattern {
    public static void main(String[] args) {
        DrawApi redPen = new RedPen();
        DrawApi bluePen = new BluePen();
        DrawApi greenPen = new GreenPen();
        Shape circle = new Circle(redPen,1,1,1);
        Shape triangle = new Triangle(redPen, 1, 1, 1);
        circle.draw();
        triangle.draw();
        circle.setDrawApi(bluePen);
        triangle.setDrawApi(bluePen);
        circle.draw();
        triangle.draw();
    }
}

// 画图的API集合
interface DrawApi{
    // 画图的方法
    void draw(int radius,int x,int y);
}

// 红色的画笔的类
class RedPen implements DrawApi{

    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("红笔作画----Radius："+radius+"X："+x+"Y："+y);
    }
}

class BluePen implements DrawApi{

    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("蓝笔作画----Radius："+radius+"X："+x+"Y："+y);
    }
}

class GreenPen implements DrawApi{

    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("绿笔作画----Radius："+radius+"X："+x+"Y："+y);
    }
}

// 形状的画法
abstract class Shape{
    protected DrawApi drawApi;

    // 想用什么笔来画，就传什么笔进来
    public Shape(DrawApi drawApi) {
        this.drawApi = drawApi;
    }

    public abstract void draw();

    public void setDrawApi(DrawApi drawApi) {
        this.drawApi = drawApi;
    }
}

// 圆形
class Circle extends Shape{

    private int radius;

    private int x;

    private int y;

    public Circle(DrawApi drawApi, int radius, int x, int y) {
        super(drawApi);
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        drawApi.draw(radius,x,y);
        System.out.println("画出了一个圆形");
    }

    @Override
    public void setDrawApi(DrawApi drawApi) {
        super.setDrawApi(drawApi);
    }
}

// 三角形
class Triangle extends Shape{
    private int radius;

    private int x;

    private int y;

    public Triangle(DrawApi drawApi, int radius, int x, int y) {
        super(drawApi);
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        drawApi.draw(radius,x,y);
        System.out.println("画出了一个三角形");
    }

    @Override
    public void setDrawApi(DrawApi drawApi) {
        super.setDrawApi(drawApi);
    }
}
