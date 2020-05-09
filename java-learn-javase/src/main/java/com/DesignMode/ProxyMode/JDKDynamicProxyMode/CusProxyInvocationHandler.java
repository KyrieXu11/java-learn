package com.DesignMode.ProxyMode.JDKDynamicProxyMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author KyrieXu
 * @date 2020/2/8 15:28
 **/
public class CusProxyInvocationHandler implements InvocationHandler {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), this.userService.getClass().getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(userService, args);
        log(method.getName());
        return invoke;
    }

    public void log(String msg){
        System.out.println(msg+"方法执行了一次！\n--------------------------");
    }
}
