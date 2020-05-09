package com.DesignMode.BuilderMode.pattern01;

/**
 * @author KyrieXu
 * @date 2020/1/22 15:17
 *
 * 打工的，还需要有人指挥工人来建造产品
 **/
public class Worker implements Builder{
    private Product product;

    public Worker() {
//        工人负责创建产品
        this.product=new Product();
    }

    @Override
    public void buildA() {
        product.setProductA("建造A");
    }

    @Override
    public void buildB() {
        product.setProductB("建造B");
    }

    @Override
    public void buildC() {
        product.setProductC("建造C");
    }

    @Override
    public void buildD() {
        product.setProductD("建造D");
    }

    @Override
    public Product getProduct() {
        return this.product;
    }
}
