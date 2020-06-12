package com.Test;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author KyrieXu
 * @since 2020/2/22 22:04
 **/
public class MapTest {

    @Test
    public void Map01() throws InvocationTargetException, IllegalAccessException {
        Map<String,String> map=new HashMap<>();
        map.put(null,"123");

    }
}
