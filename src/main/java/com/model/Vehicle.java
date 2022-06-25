package com.model;

import java.sql.Timestamp;

public class Vehicle {

    //车辆id
    private int ID;
    //车辆当前使用者id
    private int UserID;
    //车牌
    private String PlateNumber;
    //车辆购买日期
    private Timestamp PurchasingDate;
    //车辆购买价格
    private int PurchasingPrice;
    //车辆购买人
    private String Purchaser;
    //是否删除0未，1已删除
    private int DeleteFlag;
    //车辆品牌
    private String Vehiclebrand;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPlateNumber() {
        return PlateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        PlateNumber = plateNumber;
    }

    public Timestamp getPurchasingDate() {
        return PurchasingDate;
    }

    public void setPurchasingDate(Timestamp purchasingDate) {
        PurchasingDate = purchasingDate;
    }

    public int getPurchasingPrice() {
        return PurchasingPrice;
    }

    public void setPurchasingPrice(int purchasingPrice) {
        PurchasingPrice = purchasingPrice;
    }

    public String getPurchaser() {
        return Purchaser;
    }

    public void setPurchaser(String purchaser) {
        Purchaser = purchaser;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getVehiclebrand() {
        return Vehiclebrand;
    }

    public void setVehiclebrand(String vehiclebrand) {
        Vehiclebrand = vehiclebrand;
    }

    public int getDeleteFlag() {
        return DeleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        DeleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "ID=" + ID +
                ", UserID=" + UserID +
                ", PlateNumber='" + PlateNumber + '\'' +
                ", PurchasingDate=" + PurchasingDate +
                ", PurchasingPrice=" + PurchasingPrice +
                ", Purchaser='" + Purchaser + '\'' +
                ", DeleteFlag=" + DeleteFlag +
                ", Vehiclebrand='" + Vehiclebrand + '\'' +
                '}';
    }
}
