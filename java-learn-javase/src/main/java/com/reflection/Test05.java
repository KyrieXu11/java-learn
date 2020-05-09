package com.reflection;

/**
 * @author KyrieXu
 * @date 2020/1/19 11:48
 **/
public class Test05 {
    public Test05() {
    }

    private Integer prop;

    public Integer getProp() {
        return prop;
    }

    public void setProp(Integer prop) {
        this.prop = prop;
    }

    public Test05(Integer prop) {
        this.prop = prop;
    }
}
