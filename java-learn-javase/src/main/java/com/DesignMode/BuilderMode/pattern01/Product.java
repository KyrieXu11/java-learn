package com.DesignMode.BuilderMode.pattern01;

/**
 * @author KyrieXu
 * @date 2020/1/22 15:15
 * 产品类
 **/
public class Product {
    private String ProductA;
    private String ProductB;
    private String ProductC;
    private String ProductD;

    @Override
    public String toString() {
        return "Product{" +
                "ProductA='" + ProductA + '\'' +
                ", ProductB='" + ProductB + '\'' +
                ", ProductC='" + ProductC + '\'' +
                ", ProductD='" + ProductD + '\'' +
                '}';
    }

    public String getProductA() {
        return ProductA;
    }

    public void setProductA(String productA) {
        ProductA = productA;
    }

    public String getProductB() {
        return ProductB;
    }

    public void setProductB(String productB) {
        ProductB = productB;
    }

    public String getProductC() {
        return ProductC;
    }

    public void setProductC(String productC) {
        ProductC = productC;
    }

    public String getProductD() {
        return ProductD;
    }

    public void setProductD(String productD) {
        ProductD = productD;
    }

}
