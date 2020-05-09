package com.CommonClass;

import org.junit.Test;

import java.util.*;

/**
 * @author KyrieXu
 * @date 2020/1/28 14:49
 **/
public class ComparatorDemo {

    @Test
    public void ComparatorTest01(){
        Comparator<Person> comparator=new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        List<Person> people=new ArrayList<>();
        Person p1=new Person("bcd");
        Person p2=new Person("abc");
        people.add(p1);
        people.add(p2);
        people.sort(comparator);
        Iterator<Person> iterator=people.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

