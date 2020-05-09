package com.DesignMode.ProxyMode.CglibDynamicProxyMode;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

/**
 * @author KyrieXu
 * @date 2020/2/8 23:59
 **/
public class TestCglib {
    @Test
    public void Test01() throws IOException {
//        获取resources文件夹的方法
        String f = Objects.requireNonNull(this.getClass().getClassLoader().getResource("")).getFile();
        BufferedWriter writer=new BufferedWriter(new FileWriter(new File(f+"/DEBUG.txt")));
        writer.write(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY);
        writer.close();
//        虽然不知道为什么要创建这个对象，但是博客上面写着创建，那就实试一试吧
        Enhancer enhancer=new Enhancer();
//        设置目标的类对象
        enhancer.setSuperclass(Host.class);
        enhancer.setCallback(new CusInterceptor());
        Host host = (Host) enhancer.create();
        host.Rent();
    }

}
