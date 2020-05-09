package com.DesignMode.ProxyMode.StaticProxyMode.Demo01;

/**
 * @author KyrieXu
 * @date 2020/2/8 15:00
 * 代理，即中介
 **/
public class Proxy implements Rent {

    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        host.rent();
    }
}
