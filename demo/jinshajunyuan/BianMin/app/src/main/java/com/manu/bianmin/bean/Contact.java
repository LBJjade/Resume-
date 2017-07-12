package com.manu.bianmin.bean;

/**
 * Created by min on 2017/7/12.
 */

public class Contact {
    private String phone;
    private int isShow;
    private int thumbs;
    private int sID;//排名
    private String name;
    private String className;//来自哪个表

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIsShow() {
        return isShow;
    }

    public void setIsShow(int isShow) {
        this.isShow = isShow;
    }

    public int getThumbs() {
        return thumbs;
    }

    public void setThumbs(int thumbs) {
        this.thumbs = thumbs;
    }

    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phone='" + phone + '\'' +
                ", isShow=" + isShow +
                ", thumbs=" + thumbs +
                ", sID=" + sID +
                ", name=" + name +
                '}';
    }
}
