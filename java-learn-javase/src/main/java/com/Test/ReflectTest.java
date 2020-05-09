package com.Test;

import com.DesignMode.AbstracFactoryMode.ApplePhone;
import lombok.SneakyThrows;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @author KyrieXu
 * @date 2020/2/19 17:00
 **/
public class ReflectTest {

    @SneakyThrows
    @Test
    public void test(){
        Class<?> aClass = Class.forName("com/Test/TestReflectClass".replace('/','.'));
//        TestReflectClass reflectClass = (TestReflectClass) aClass.getConstructor().newInstance();
    }

    @SneakyThrows
    @Test
    public void test01(){
        Class<?> aClass = ClassLoader.getSystemClassLoader().loadClass("com/Test/TestReflectClass".replace('/','.'));
//        TestReflectClass reflectClass = (TestReflectClass) aClass.getConstructor().newInstance();

    }
}


class TestReflectClass{
    static {
        System.out.println("执行了静态代码块");
    }

    public TestReflectClass(){
        System.out.println("无参构造方法被执行");
    }

    public void TestMethod(){
        System.out.println("执行了这个方法");
    }
}
