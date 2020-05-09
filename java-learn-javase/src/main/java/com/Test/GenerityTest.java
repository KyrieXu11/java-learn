package com.Test;

import org.junit.Test;

import java.util.List;

/**
 * @author KyrieXu
 * @since 2020/3/3 18:33
 **/
public class GenerityTest {

    @Test
    public void test01(){
        G1 g1=new G1();
        List ga = g1.Ga("123");
        System.out.println(ga.toString());
    }
}

class G1{
    public <T> T Ga (String a){
        return (T) a;
    }
}
