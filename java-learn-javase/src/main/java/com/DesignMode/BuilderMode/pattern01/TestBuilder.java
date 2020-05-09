package com.DesignMode.BuilderMode.pattern01;

/**
 * @author KyrieXu
 * @date 2020/1/22 15:23
 **/
public class TestBuilder {
    public static void main(String[] args) {
        Director director=new Director();
        Product product = director.build(new Worker());
        System.out.println(product);
    }
}
