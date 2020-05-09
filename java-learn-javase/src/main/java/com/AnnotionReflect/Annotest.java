package com.AnnotionReflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author KyrieXu
 * @since 2020/3/15 15:37
 **/
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Annotest {
    String value() default "这是一个注解";

    String key() default "这是一个注解";
}

class AnnotestReflect{
    public void test(){
    }
}