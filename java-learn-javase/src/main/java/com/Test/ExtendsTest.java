package com.Test;

import org.junit.Test;

/**
 * @author KyrieXu
 * @date 2020/1/30 11:50
 **/
public class ExtendsTest {
    @Test
    public void ETest(){
        Student student=new Student("fuckName");
        System.out.println(student.getName());
    }

    @Test
    public void TestBclass(){
        BB bb = new BB();
        bb.sout();
        String s = "tommy";
        Object o = s;
        BA.sayHello(o); //语句1
        BA.sayHello(s); //语句2
    }
    @Test
    public void TestBBclas(){
        BBC bbc = new BBC();
    }
}


class Person{
    public Person() {
        System.out.println("fuck");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Person(String name) {
        this.name = name;
    }

}

class Student extends Person {
    public Student() {
    }

    public Student(String name) {
        super(name);
    }
}

class Base{
    public Base(String s){
        System.out.print("B");
    }
}
class Derived extends Base{

    Derived (String s) {
        super(s);
        System.out.print("D");
    }
    public static void main(String[] args){
        new Derived("C");
    }
}




class BA{
    public static void sayHello(String to) {
        System.out.println(String.format("Hello, %s", to));
    }
    public static void sayHello(Object to) {
        System.out.println(String.format("Welcome, %s", to));
    }

    // 不能被重写
    public final void method(){

    }
    // 可以被重载
    public final void method(int a){

    }

    public void sout(){
        System.out.println("父类的方法");
    }
    public BA() {
        System.out.println("父类");
    }
}

class BB extends BA{
    private BC bc;
    public BB() {
        super();
        System.out.println("子类本身");
    }
}

class BC{
    public BC() {
        System.out.println("子类成员");
    }
}

abstract class BD{
    // 可以有private属性
    private int a=10;
}

class BBB{
    static {
        System.out.println("父类静态代码块");
    }
    {
        System.out.println("父类代码块");
    }

    public BBB() {
        System.out.println("父类构造函数");
    }
}

class BBC extends BBB{

    {
        System.out.println("子类代码块");
    }
    static {
        System.out.println("子类静态代码块");
    }

    public BBC() {
        super();
        System.out.println("子类构造函数");
    }
}
