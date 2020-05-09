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