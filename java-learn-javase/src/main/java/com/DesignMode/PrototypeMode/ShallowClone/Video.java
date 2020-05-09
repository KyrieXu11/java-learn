package com.DesignMode.PrototypeMode.ShallowClone;

import java.util.Date;

/**
 * @author KyrieXu
 * @date 2020/1/22 13:55
 *
 *
 * 实现步骤：
 *  1. 实现一个接口
 *  2. 重写一个方法
 *
 **/
//  1. 实现了Cloneable接口 Cloneable为空
//  2. 重写了clone()方法
public class Video implements Cloneable {
    private String title;
    private Date createDate;

    @Override
    public String toString() {
        return "Video{" +
                "title='" + title + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Video() {
    }

    public Video(String title, Date createDate) {
        this.title = title;
        this.createDate = createDate;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
