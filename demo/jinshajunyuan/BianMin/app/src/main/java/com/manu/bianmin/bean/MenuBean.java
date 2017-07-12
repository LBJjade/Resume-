package com.manu.bianmin.bean;

import java.io.Serializable;

/**
 * Created by min on 2017/7/12.
 */

public class MenuBean implements Serializable {

    public String menuId = "";
    public int status = 0; //0是已经存在，1 不在寻
    public String title = "";//主题
    public int code = 0;
    public String classStr;
    public String resDraw;
    public String content;//说明文字
    public int res;//图片id
    public int from = 0;//0是家长  1是教师 2.校长 3职工
    public int unread = 0;
    public String className = "";//查什么表

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getClassStr() {
        return classStr;
    }

    public void setClassStr(String classStr) {
        this.classStr = classStr;
    }

    public String getResDraw() {
        return resDraw;
    }

    public void setResDraw(String resDraw) {
        this.resDraw = resDraw;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getUnread() {
        return unread;
    }

    public void setUnread(int unread) {
        this.unread = unread;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
