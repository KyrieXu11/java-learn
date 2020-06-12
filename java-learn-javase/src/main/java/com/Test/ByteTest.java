package com.Test;

import org.junit.Test;

/**
 * @author KyrieXu
 * @since 2020/6/4 18:15
 **/
public class ByteTest {
    @Test
    public void TestByte1(){
        byte a = 1;
        byte b = 2;
        b+=a; // 可运行
        // b=a+b; 不可运行

        System.out.println(b);
    }

    @Test
    public void Testbyte2(){
        byte a= 10;
        int b=-a;
        System.out.println(b);
    }
}
