package com.Test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KyrieXu
 * @date 2020/1/25 23:01
 **/
public class JavaTest02 {
    public static void main(String[] args) {
        
    }

    @Test
    public void TestError(){
        test("2");
    }

    final List<String> list = new ArrayList<>();
    public void test(String str){
        int i = 1, s = 1, f = 1, a = 1, b = 1,c = 1,d = 1,e = 1;
        list.add(new String("11111111111111111111111111111"));
        test(s+i+f+a+b+c+d+e+"");
    }

    @Test
    public void Test(){

    }

}

class Normal{
    private String a;

    public Normal(String a) {
        this.a = a;
    }

    public Normal() {
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}


class OBJ<T> {
//    T getStr(Class<T> clazz){
//
//    }
}
