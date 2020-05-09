package com.DesignMode.ProxyMode.CglibDynamicProxyMode;

/**
 * @author KyrieXu
 * @date 2020/2/8 20:20
 *
 * Cglib有三个类：
 * 1. 目标类
 * 2. 拦截器
 * 3. 代理类
 * 这个房东类算是目标类
 **/
public class Host {
    public void Rent(){
        System.out.println("房东想把房子租出去");
    }
}
