package com.Collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author KyrieXu
 * @date 2020/1/29 12:19
 **/
public class MapApi {
    /*
        HashMap: Map的主要实现类，线程不安全，效率高；存储 null 的 key 和 value
            LinkedHashMap: HashMap的子类；保证遍历map元素的时候，能够按照添加的顺序遍历
                           原因： 底层实现是双向链表；频繁的遍历效率高于HashMap
        TreeMap: 按照Key来排序；底层实现是红黑树
        HashTable: 古老实现类，线程安全的；不能存储 null 的 key 和 value
            Properties:


        HashMap的底层实现：
            数组+链表 (JDK7以及之前)
            数组+链表+红黑树 (JDK8)
        HashMap的底层源码分析：
        jdk7:
            HashMap map = new HashMap(); 首先初始化长度为16的Entry[] 数组， 默认的加载因子是 0.75
            map.put(key,value); 的实现原理是：
                首先调用key所在的类的hashcode()，计算出其哈希值，然后经过某种算法之后，得到在Entry数组中的位置
                如果该位置上的数据为空，此时的Key-Value添加成功。
                如果该位置上的数据不为空，意味着此位置上存在一个或多个数据(以链表的形式存在)，比较key和已存在的一个或多个数据的哈希值
                    如果key的哈希值不同，添加成功
                    如果和(key2-value2)的哈希值相同，继续比较，调用key所在类的equal(key2)
                        如果返回为false，添加成功
                        如果返回true，使用value替换key2的value2
        不断添加的时候会面对扩容问题，扩容时，默认扩大为原来的2倍，并且将原有数据复制过去

        jdk8:
        相较于上面不同的几点是:
        1. 创建实例的时候没有创建大小为16的数组
        2. 底层使用的是Node[] 而非 Entry[]
        3. 首次调用put()时，创建大小为16的数组(和ArrayList一样)

     */
    @Test
    public void MapDemo01(){
        Map map=new HashMap();
        map.put(null,null); // 正常运行
        //Map map1=new Hashtable();
        //map1.put(null,null);    // 抛出空指针异常
    }
}
