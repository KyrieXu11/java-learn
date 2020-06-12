package com.Test;

import org.junit.Test;

/**
 * @author KyrieXu
 * @since 2020/6/4 18:18
 **/
public class IntTest {
    @Test
    public void TestInt1(){
        int[] a = new int[10];
        int[] b = new int[10];
        // 数组是一个对象
        System.out.println(a instanceof Object);
        // 输出false,并不会一一遍历
        System.out.println(a.equals(b));
    }
    @Test
    public void Testinteger(){
        // 自动拆箱
        Integer a = 1;
        Integer b = 1;
        // 超出缓存区-127~128
        Integer c = 500;
        Integer d = 500;
        System.out.print(a == b);
        System.out.print(c == d);
    }
}
