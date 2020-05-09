package com.DesignMode.AbstracFactoryMode;

public interface IProductFactory {
    IPhoneProduct PhoneProduct();

    IRouterProduct RouterProduct();
}
