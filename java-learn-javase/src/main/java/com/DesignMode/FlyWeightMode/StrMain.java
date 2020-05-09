package com.DesignMode.FlyWeightMode;

/**
 * @author KyrieXu
 * @date 2020/2/16 15:59
 * 享元模式就是，针对代码复用的情况，就像String一样，一旦被创建了，就放在常量池中，下次如果有引用的话，不需要再次被创建
 **/
public class StrMain {
    public static void main(String[] args) {
        StrNode node=new StrNode(123,123,StrFactory.getStr("name","value"));
        StrNode node2=new StrNode(123,123,StrFactory.getStr("name","value"));
        StrNode node3=new StrNode(123,123,StrFactory.getStr("name1","value"));
        StrNode node4=new StrNode(123,123,StrFactory.getStr("name1","value"));
    }
}
