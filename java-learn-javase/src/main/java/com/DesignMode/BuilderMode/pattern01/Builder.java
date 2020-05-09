package com.DesignMode.BuilderMode.pattern01;

/**
 * @author KyrieXu
 * @date 2020/1/22 15:14
 **/
//  抽象类：建造者
public interface Builder {
    void buildA();
    void buildB();
    void buildC();
    void buildD();
//    建造完成后之后得到产品
    Product getProduct();
}
