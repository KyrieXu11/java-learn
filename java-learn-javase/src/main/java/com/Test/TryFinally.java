package com.Test;

import org.junit.Test;

/**
 * @author KyrieXu
 * @date 2020/2/16 15:22
 **/
public class TryFinally {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        int i=0;
        try {
            i++;
            System.out.println("try"+i);
            i++;
            System.out.println("try"+i);
            return;
        }catch (Exception e){

        }finally {
            i++;
            System.out.println("finally"+i);
        }
    }

    @Test
    public void TestFinal(){

    }

}
