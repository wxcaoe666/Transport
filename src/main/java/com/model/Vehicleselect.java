package com.model;

public class Vehicleselect {

    private String selectname;

    private int selectid;

    private String selectbrand;

    private String selectnum;

    private int pageNum;

    private int pageSize;

    @Override
    public String toString() {
        return "Vehicleselect{" +
                "selectname='" + selectname + '\'' +
                ", selectid=" + selectid +
                ", selectbrand='" + selectbrand + '\'' +
                ", selectnum='" + selectnum + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }

    public String getSelectname() {
        return selectname;
    }

    public void setSelectname(String selectname) {
        this.selectname = selectname;
    }

    public int getSelectid() {
        return selectid;
    }

    public void setSelectid(int selectid) {
        this.selectid = selectid;
    }

    public String getSelectbrand() {
        return selectbrand;
    }

    public void setSelectbrand(String selectbrand) {
        this.selectbrand = selectbrand;
    }

    public String getSelectnum() {
        return selectnum;
    }

    public void setSelectnum(String selectnum) {
        this.selectnum = selectnum;
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
}
