package com.DesignMode.AbstracFactoryMode;

public class Client {
    public static void main(String[] args) {
        MiFactory miFactory=new MiFactory();
        IPhoneProduct miPhoneProduct = miFactory.PhoneProduct();
        IRouterProduct miRouterProduct = miFactory.RouterProduct();
        miPhoneProduct.start();
        miPhoneProduct.callup();
        miPhoneProduct.sendMessage();
        miPhoneProduct.shutdown();
        miRouterProduct.start();
        miRouterProduct.setting();
        miRouterProduct.openWifi();
        miRouterProduct.shutdown();

    }
}
