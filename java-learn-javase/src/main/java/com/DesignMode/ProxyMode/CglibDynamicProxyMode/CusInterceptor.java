package com.DesignMode.ProxyMode.CglibDynamicProxyMode;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author KyrieXu
 * @date 2020/2/8 20:22
 **/
public class CusInterceptor implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log("方法执行前调用日志");
        return methodProxy.invokeSuper(o, objects);
    }

    private void log(String msg){
        System.out.println("日志是："+msg);
    }
}
