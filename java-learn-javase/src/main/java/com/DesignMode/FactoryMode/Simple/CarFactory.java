package com.DesignMode.FactoryMode.Simple;

//  不满足开闭原则
public class CarFactory {
    public static Car getCar(String car){
        if("宝马".equals(car)){
            return new BMW();
        }else if ("特斯拉".equals(car)){
            return new Tesla();
        }else
            return null;
    }
}
