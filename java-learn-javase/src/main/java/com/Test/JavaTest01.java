package com.Test;

/**
 * @author KyrieXu
 * @date 2020/1/22 14:08
 **/
public class JavaTest01 {
    public static void main(String[] args) {
        Orange orange=new Orange(123);
        Apple apple =new Apple();
        apple.setOrange(orange);
        System.out.println(apple);
        orange.setName(12222);
        System.out.println(apple);
    }
}

class Orange{
    private Integer name;

    @Override
    public String toString() {
        return "Orange{" +
                "name=" + name +
                '}';
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Orange(Integer name) {
        this.name = name;
    }
}

class Apple{
    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", orange=" + orange +
                '}';
    }

    private String name;

    public Apple() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Orange getOrange() {
        return orange;
    }

    public void setOrange(Orange orange) {
        this.orange = orange;
    }

    private Orange orange;

    public Apple(String name, Orange orange) {
        this.name = name;
        this.orange = orange;
    }
}
