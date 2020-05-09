package com.Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author KyrieXu
 * @date 2020/1/29 11:05
 **/
public class ListApi {

    @Test
    public void ListDemo01(){
        /*
            由于数组有局限性，所以用集合来代替数组
            List集合类中元素可重复且有序，都有一个序号来记录元素存放的位置
            常见的实现类有： ArrayList<>() LinkedList<>() Vector<>()
            ArrayList 、 LinkedList 、 Vector 三者的异同：
                同： 1. 三个类都实现了List接口，存储数据的特点都是可重复且有序的
                不同： ArrayList: 作为List的主要实现类，线程不安全，效率高；底层使用 Object[] 存储
                      LinkedList: 底层使用双向链表存储，对于频繁的`插入`、删除来说，使用效率比 ArrayList 高,添加还是ArrayList效率高
                      Vector: 作为古老的List实现类，线程安全，效率低；底层使用 Object[] 存储
            ArrayList源码分析：
                ArrayList list=new ArrayList();
                上面的代码在jdk7是初始化创建了一个长度为10的 Object 数组
                而在jdk8、jdk11的时候初始化为`{}`，即空数组，是在添加的再创建一个大小为10的 Object 数组
                扩容的时候扩容为原来的1.5倍，扩容之后还要将源列表的内容复制到新列表中去
            LinkedList的源码分析：
                有一个静态内部类：
                    private static class Node<E> {
                        E item;
                        Node<E> next;
                        Node<E> prev;

                        Node(Node<E> prev, E element, Node<E> next) {
                            this.item = element;
                            this.next = next;
                            this.prev = prev;
                        }
                      }

         */

    }
}
