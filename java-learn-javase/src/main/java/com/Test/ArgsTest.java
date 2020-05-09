package com.Test;

import org.junit.Test;

/**
 * @author KyrieXu
 * @date 2020/2/10 16:32
 **/
public class ArgsTest {
    @Test
    public void TestArgs(){
        String s = Test01("123", "234", "456");
        System.out.println(s);
    }

    private String Test01(String... a){
        StringBuilder sb=new StringBuilder();
        for (String s : a) {
            sb.append(s);
        }
        return sb.toString();
    }
}
