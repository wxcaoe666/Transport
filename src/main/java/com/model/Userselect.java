package com.model;

public class Userselect {

    private String selectname;

    private int selectage;

    private int selectsex;

    private String selectrole;

    private int pageNum;

    private int pageSize;

    @Override
    public String toString() {
        return "Userselect{" +
                "selectname='" + selectname + '\'' +
                ", selectage=" + selectage +
                ", selectsex=" + selectsex +
                ", selectrole='" + selectrole + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSelectname() {
        return selectname;
    }

    public void setSelectname(String selectname) {
        this.selectname = selectname;
    }

    public int getSelectage() {
        return selectage;
    }

    public void setSelectage(int selectage) {
        this.selectage = selectage;
    }

    public int getSelectsex() {
        return selectsex;
    }

    public void setSelectsex(int selectsex) {
        this.selectsex = selectsex;
    }

    public String getSelectrole() {
        return selectrole;
    }

    public void setSelectrole(String selectrole) {
        this.selectrole = selectrole;
    }

}
