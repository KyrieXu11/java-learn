package com.DesignMode.FlyWeightMode;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author KyrieXu
 * @date 2020/2/16 15:54
 **/
public class StrFactory {
    public static Map<String,Str> map=new ConcurrentHashMap<>();

    public static Str getStr(String name,String val){
//        如果有这个str的话，直接返回
        if(map.containsKey(name)){
            return map.get(name);
        }
//        如果没有这个字符串的话，那就新建字符串，并且把这个字符串放到map中去
        Str str=new Str(name,val);
        map.put(name,str);
        return str;
    }
}
