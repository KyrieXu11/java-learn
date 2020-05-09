package com.DesignMode.ProxyMode.JDKDynamicProxyMode;

import org.junit.Test;

/**
 * @author KyrieXu
 * @date 2020/2/8 15:36
 * 动态代理实现类
 **/
public class TestProxy {
    @Test
    public void Test01(){
        UserService userService=new UserServiceImpl();
        CusProxyInvocationHandler proxy=new CusProxyInvocationHandler();
        proxy.setUserService(userService);
        UserService u1 = (UserService) proxy.getProxy();
        u1.add();
        u1.delete();
        u1.update();
        u1.query();
    }
}
