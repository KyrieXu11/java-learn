package com.DesignMode.ProxyMode.StaticProxyMode.Demo01;

/**
 * @author KyrieXu
 * @date 2020/2/8 14:58
 * 房东类
 **/
public class Host implements Rent {
    @Override
    public void rent() {
        System.out.println("房东出租房子");
    }
}
