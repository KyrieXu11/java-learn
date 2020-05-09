package com.Test;

import org.junit.Test;

/**
 * @author KyrieXu
 * @date 2020/2/16 17:39
 **/
public class ParseTest {
    @Test
    public void StringToInt(){
        int res = Integer.parseInt("123");
        System.out.println(res);
//        int res = Integer.parseInt("abc");    //报出异常

    }
}
