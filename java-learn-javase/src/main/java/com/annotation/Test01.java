package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Annotatio
public class Test01 {

    //使用方法就是
    //注解内方法名称 = 要求的类型的值
    @Annotatio(name = "我是赋值进去的值")
    public String name(){
        return null;
    }

    //如果注解内方法有且仅有一个，那么可以不用指定方法名称
    //但是要符合数据类型的要求
    @DefaultParam("123")
    public void name2(){
    }
}

//ElementType.TYPE : 表示可以使用在类上
//ElementType.METHOD ： 表示可以使用在方法上
@Target({ElementType.TYPE,ElementType.METHOD})
//在运行时生效
@Retention(RetentionPolicy.RUNTIME)
@interface Annotatio{

    //方法不能指定参数，不然会报错
    String name() default "我是默认值";
}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface DefaultParam{
    String value();
}
