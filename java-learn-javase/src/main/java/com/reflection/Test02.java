package com.reflection;

import java.lang.reflect.Field;

//获取反射对象
public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
//        1.使用Class.forName() 获取class对象
        Class c1 = Class.forName("root.reflection.Student");
        Class c2 = Class.forName("root.reflection.Student");
//        由于一个类只能有一个class类对象，所以这两个对象的hashcode是相等的
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());

//        2.使用`类名.class`来获取class对象
        Class c3 = Student.class;
//        得到的结果和上面是一样的
        System.out.println(c3.hashCode());

//        3.使用实例化对象来获取class对象
        Student student = new Student();
        Class c4 = student.getClass();
//        结果和上面的是一样的
        System.out.println(c4.hashCode());
        student.setId(111);
        Field f = c4.getDeclaredField("id");
//        设置可以访问
        f.setAccessible(true);
//        设置student对象的id的值
        f.set(student,123);
//        获取student对象的id的值
        System.out.println(f.get(student));
    }

}

class Student {
    private Integer id;

    private String name;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}