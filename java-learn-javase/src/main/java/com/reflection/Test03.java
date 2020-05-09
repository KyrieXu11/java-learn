package com.reflection;

//获取父类类型
public class Test03 {
    public static void main(String[] args) {
        Class c1 = Student2.class;
//        通过getSuperclass来获取父类的class对象
        Class c1Super = c1.getSuperclass();
        System.out.println(c1Super.hashCode());
        Class c2=Person.class;
        System.out.println(c2.hashCode());
    }
}

class Person{
    Person() {
    }

    String name;

    public Person(String name) {
        this.name = name;
    }
}

class Student2 extends Person{
    public Student2() {
        this.name = "学生";
    }
}

class Teacher2 extends Person{
    public Teacher2(){
        this.name = "老师";
    }
}
