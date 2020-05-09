package com.CommonClass;

import org.junit.Test;

/**
 * @author KyrieXu
 * @date 2020/1/28 11:41
 **/
public class StringBufferBuilder {

    @Test
    public void Test01(){
        /*
            String StringBuffer 和 StringBuilder 的区别
            String: 不可变字符序列；
            StringBuffer: 可变的字符序列；效率低，因为是线程安全的
            StringBuilder: 可变的字符序列；效率高，因为是线程不安全的
            相同点：1. Builder 和 Buffer 的用法基本相同
                   2. 三者都是final类型的，即不可继承
                   3. 三个底层都使用 char[] 存储
            扩容的原理：
                1. 默认情况下扩容为原来容量的2倍+2
                2. 由于扩容的时候要将整个字符串复制一份，所以效率会大大降低，所以要避免频繁扩容
                3. 如果要大量进行字符串的操作，建议一开始就指定好 StringBuffer 的容量
         */
        StringBuffer sb1=new StringBuffer();
        System.out.println(sb1.capacity()); // 16,新建对象的时候，默认创建出char数组的长度是16即char[] value=new char[16];

        sb1.append('a');
        sb1.append('b');
        System.out.println(sb1.capacity()); // 还是输出16，因为上面两个操作相当于执行了value[0]='a',value[1]='b'
        System.out.println(sb1.length());   // 2，输出了非空字符的长度

        StringBuffer sb2=new StringBuffer("abc");
        System.out.println(sb2.capacity()); // 19,因为相当于char[] value=new char[16+"abc".length()]

        StringBuffer sb3=new StringBuffer("a1b2c3d4e5f6g7h8");    //  共16个字符
        System.out.println(sb3.length());
        System.out.println(sb3.capacity()); // 32,用了16个字符，底层默认容量不够了，又新建了一个大小为16的char数组

        String str=null;
        sb2.delete(0,sb2.length()); // 清空 sb2 中所有的字符
        sb2.append(str);
        System.out.println(sb2.length());   // 输出4
        System.out.println(sb2);    // 将 “null”存入sb2中，所以长度才是4
//        而 StringBuffer sb2=new StringBuffer(str); 会报空指针异常
    }
}
