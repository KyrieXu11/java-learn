package com.DesignMode.ProxyMode.StaticProxyMode.Demo01;

/**
 * @author KyrieXu
 * @date 2020/2/8 14:59
 * 客户类，想要租房
 **/
public class Consumer  {
    public static void main(String[] args) {
//        房东想要出租房子
        Host host=new Host();
//        将房子出租的事情交给了中介
        Proxy proxy=new Proxy(host);
//        客户找中介租房
        proxy.rent();
    }
}
