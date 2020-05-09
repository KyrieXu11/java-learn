package com.DesignMode.ProxyMode.StaticProxyMode.Demo02;

/**
 * @author KyrieXu
 * @since 2020/3/11 13:55
 **/
public class ProxyMain {
    public static void main(String[] args) {
        UserServiceProxy proxy = new UserServiceProxy();
        proxy.updateUser();
        System.out.println("--------------------");
        proxy.getUserId();
        System.out.println("--------------------");
        proxy.deleteUser();
        System.out.println("--------------------");
    }
}
