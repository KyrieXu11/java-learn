package com.Test;

import org.junit.Test;
import org.w3c.dom.ls.LSException;

import java.util.*;
import java.util.concurrent.DelayQueue;

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
    @Test
    public void TestRemove(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (Integer num : list) {
            list.remove(num);
        }
        // for (Iterator<Integer> i = list.iterator(); i.hasNext(); ) {
        //     i.next();
        //     i.remove();
        // }
        System.out.println(list);
    }

    @Test
    public void TestGeneric(){
        List<?> list = new ArrayList<>();
        List<? extends Collection> lst = new ArrayList<>();
        List<LinkedList> l = new ArrayList<>();
        List<DelayQueue> i = new ArrayList<>();

    }
}
