package com.DesignMode.FlyWeightMode;

import lombok.Data;

/**
 * @author KyrieXu
 * @date 2020/2/16 15:49
 **/
@Data
public class Str {
    private final String name;
    private final String val;

    public Str(String name, String val) {
        System.out.println("字符串："+name+" 被创建了");
        this.name = name;
        this.val = val;
    }
}
