package com.DesignMode.AbstracFactoryMode;

public class MiFactory implements IProductFactory {
    @Override
    public IPhoneProduct PhoneProduct() {
        return new MiPhone();
    }

    @Override
    public IRouterProduct RouterProduct() {
        return new MiRouter();
    }
}
