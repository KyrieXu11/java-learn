package com.DesignMode.PrototypeMode.DeepClone;

import java.util.Date;

/**
 * @author KyrieXu
 * @date 2020/1/22 14:28
 **/
public class DVideo implements Cloneable {

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

    public DVideo() {
    }

    public DVideo(String title, Date createDate) {
        this.title = title;
        this.createDate = createDate;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        DVideo v2 = ((DVideo) super.clone());
        v2.createDate= ((Date) this.createDate.clone());
        return v2;
    }
}
