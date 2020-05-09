package com.DesignMode.AbstracFactoryMode;

public class AppleFactory implements IProductFactory {
    @Override
    public IPhoneProduct PhoneProduct() {
        return new ApplePhone();
    }

    @Override
    public IRouterProduct RouterProduct() {
        return new ApppleRouter();
    }
}
