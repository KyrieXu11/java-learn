package com.Test;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author KyrieXu
 * @since 2020/3/22 10:54
 **/
public class ListTest {
    @Test
    public void copy(){
        int[] array = new int[]{23, 46, 0, 8, 11, 18};
        int[] num = Arrays.copyOfRange(array, 0, 4);
        for (int i : num) {
            System.out.println(i);
        }
    }
}
