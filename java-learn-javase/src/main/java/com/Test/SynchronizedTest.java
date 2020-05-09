package com.Test;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author KyrieXu
 * @date 2020/2/17 21:22
 **/
public class SynchronizedTest {
    @Test
    public void Demo01(){

    }

    private final Set<String> objectS=new HashSet<>();

    public void Debugsynchronized(){
        synchronized (this.objectS){

        }
    }
}
