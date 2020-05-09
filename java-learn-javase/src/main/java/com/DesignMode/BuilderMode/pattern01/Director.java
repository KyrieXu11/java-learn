package com.DesignMode.BuilderMode.pattern01;

/**
 * @author KyrieXu
 * @date 2020/1/22 15:21
 * 指挥构建工程
 **/
public class Director {
//    建造方法，可以自定义建造顺序
    public Product build(Builder builder){
        builder.buildA();
        builder.buildB();
        builder.buildC();
        builder.buildD();
        return builder.getProduct();
    }
}
