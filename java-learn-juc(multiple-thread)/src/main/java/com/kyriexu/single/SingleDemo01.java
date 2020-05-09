package com.kyriexu.single;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author KyrieXu
 * @since 2020/3/8 23:15
 **/
public class SingleDemo01 {
    public static void main(String[] args) {
        // 这个线程不安全，所以还要再加上同步监视器
        //S01 instance = S01.getInstance();
        /*
            com.kyriexu.single.S01@4037b851
            com.kyriexu.single.S01@4037b851
            com.kyriexu.single.S01@4037b851
            com.kyriexu.single.S01@2e00fa9
            com.kyriexu.single.S01@4037b851
            com.kyriexu.single.S01@4037b851
            com.kyriexu.single.S01@4037b851
            com.kyriexu.single.S01@4037b851
            com.kyriexu.single.S01@4037b851
            com.kyriexu.single.S01@4037b851

            从上面的结果我们可以看出，多线程环境下，这中单例模式是失败的
         */
        //for (int i = 0; i < 10; i++) {
        //    new Thread(() -> {
        //        S01 ins = S01.getInstance();
        //        System.out.println(ins);
        //    }).start();
        //}

        // S02是线程安全的懒汉式，但是不是反射安全
        // 并且，还会碰到一个问题，如果CPU自行的打乱了执行顺序的话
        // 那么创建懒汉式又会失败

        //for (int i = 0; i < 10; i++) {
        //    new Thread(() -> {
        //        S02 ins = S02.getInstance();
        //        System.out.println(ins);
        //    }).start();
        //}
    }

    // 使用反射破坏单例
    @Test
    public void reflectDestroy01() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        // 下面看如果使用反射来破坏一个单例模式
        S03 ins = S03.getInstance();
        // 空参构造器，直接传一个null 就行了
        Constructor<S03> constructor = S03.class.getDeclaredConstructor();
        // 设置无视私有属性
        constructor.setAccessible(true);
        S03 ins2 = constructor.newInstance();
        // 结果是 false 成功破坏了单例模式
        System.out.println(ins==ins2);
    }

    // 使用反射破坏单例失败，因为设置了标识变量
    @Test
    public void reflectDestroy02() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        // 下面看如果使用反射来破坏一个单例模式
        S04 ins = S04.getInstance();
        // 空参构造器，直接传一个null 就行了
        Constructor<S04> constructor = S04.class.getDeclaredConstructor();
        // 设置无视私有属性
        constructor.setAccessible(true);
        S04 ins2 = constructor.newInstance();
        // 结果是true，因为设置了一个标示变量来查看是否被反射被破坏了空参的构造器
        // 所以破解失败
        System.out.println(ins==ins2);
    }

    // 使用反射防止抛出异常
    @Test
    public void reflectDestroy03() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        S04 ins = S04.getInstance();
        // 空参构造器，直接传一个null 就行了
        Class<S04> clazz = S04.class;
        Constructor<S04> constructor = clazz.getDeclaredConstructor();
        // 设置无视私有构造方法
        constructor.setAccessible(true);
        Field flag = clazz.getDeclaredField("flag");
        // 设置无视私有属性
        flag.setAccessible(true);
        flag.setBoolean(flag,false);
        S04 ins2 = constructor.newInstance();
        // 结果是 false 成功破坏了单例模式
        // 因为破坏了标识变量
        System.out.println(ins==ins2);
    }
}

class S01 {
    private S01() {
    }

    private static S01 instance;

    public static S01 getInstance() {
        if (instance == null) {
            instance = new S01();
        }
        return instance;
    }
}

class S02{
    private S02(){
    }

    private static S02 instance;

    public static synchronized S02 getInstance(){
        if(instance==null){
            instance=new S02();
        }
        return instance;
    }
}

class S03{
    private S03(){
    }

    // 因为要取消内存壁垒，所以声明为 volatile
    private static volatile S03 instance;

    public static synchronized S03 getInstance(){
        if(instance==null){
            instance=new S03();
        }
        return instance;
    }
}

class S04{
    private S04(){
        if (!flag){
            flag=true;
        }else
            throw new RuntimeException("别用反射破解了，你啊，总给我搞出一点新花样");
    }

    private static boolean flag = false;

    // 因为要取消内存壁垒，所以声明为 volatile
    private static volatile S04 instance;

    public static synchronized S04 getInstance(){
        if(instance==null){
            instance=new S04();
        }
        return instance;
    }
}

// 反射无法破坏枚举类型的类
enum S05{
    INSTANCE;

    public S05 getInstance(){
        return INSTANCE;
    }
}