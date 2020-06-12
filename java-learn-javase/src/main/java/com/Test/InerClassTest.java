package com.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author KyrieXu
 * @date 2020/2/21 16:35
 **/
public class InerClassTest {

    public int a;

//  内部类是可以访问到外部类的成员的
    class A {
//      内部类不能有静态属性
//        static int b;

        public A() {
            a=10;
        }
    }

    public void test(){
        final int c = 10;
        class B{
            public void test(){
//                不能改变局部内部类外的变量的值
//                c=100;
                System.out.println(c);
            }
        }
    }
}


class Circle {
    private double radius = 0;
    public static int count =1;
    private static int a=1;

    public Circle(double radius) {
        this.radius = radius;
    }

    class Draw {     //内部类
        public void drawSahpe() {
            System.out.println(radius);  //外部类的private成员
            System.out.println(count);   //外部类的静态成员
            System.out.println(a);
        }
    }

    static class Draw1{
        // 静态内部类可以有静态属性
        private static int c = 1;
        public void drawSahpe() {
            // System.out.println(radius); 不可访问普通的属性
            System.out.println(count);   //外部类的静态成员
            System.out.println(c); // 内部类的静态成员
            System.out.println(a); //外部类的静态成员
        }
    }

    class Draw2{
        private int a=1;
        // 内部类不能有静态属性
        // private static int b = 2;
        public void drawSahpe() {
            class Draw3{
            //    这个是局部内部类
                public void method(){
                    // 可以访问外部类的私有属性
                    System.out.println(a);
                }
            }
        }
    }
}



class TestA{
    public static void main(String[] args){
        final List<String> urls=new ArrayList<>();
        System.out.println("url的第一个hashcode---------------------->"+urls.hashCode());
        Consumer<String> consumer= urls::add;
        consumer.accept("123");
        urls.forEach(System.out::println);
        System.out.println("urls----------------->"+urls.hashCode());
        // 虽然可以看见上面的两次输出hashcode的值不相等，但是list被定义成final，列表的首地址是不会发生改变的
        List<String> list=urls;
        urls.add("234");
        System.out.println("urls中第一个元素的hashcode----------------------->"+urls.get(0).hashCode());
        System.out.println("list中第一个元素的hashcode----------------------->"+list.get(0).hashCode());
    }
}
