package com.Collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author KyrieXu
 * @date 2020/1/29 11:45
 **/
public class SetApi {
/*
    Set集合用来存放：单列集合、存储对象、无序且不可重复
    实现类：
        HashSet:    作为Set集合的主要实现类，线程不安全，可以存储 null 值,底层就是HashMap
                    HashSet的add方法就是使用map.put
        LinkedHashSet:  是HashSet的子类；遍历它的时候可以按照添加的顺序遍历
        TreeSet: 底层实现数据结构是二叉树；可以按照添加对象的指定属性进行排序
*/
    @Test
    public void SetDemo01(){
        /*
            Set有无序性和不可重复数据的特点
            1.无序性：不是随机性，即每次遍历输出的结果都是一样的
            2.不可重复性：保证添加的元素按照equals()来判断的时候，不能返回True，即相同元素只能添加一个
         */
        Set set=new HashSet();
        set.add(new Person("Tom"));
        set.add(new Person("Tom"));
        for (Object o : set) {
            System.out.println(o);
        }
        //能输出两个对象Person{name='Tom'}
        //            Person{name='Tom'}
    }
}

class Person{
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
}
