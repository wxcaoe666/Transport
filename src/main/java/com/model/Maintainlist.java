package com.model;

import java.sql.Timestamp;

public class Maintainlist {

    //出车记录id
    private int ID;
    //车辆当前使用者id
    private int UserID;
    //用户姓名
    private String Name;
    //是否允许出车0不允许1允许
    private int IsAllow;
    //维修原因
    private String MaintainCause;
    //状态0未维修1维修中2已维修
    private int State;
    //是否删除0未，1已删除
    private int DeleteFlag;
    //运输车辆id
    private int VehicleID;
    //车牌号
    private String PlateNumber;
    //申请创建时间
    private Timestamp MaintainDate;
    //维修金额
    private int MaintenanceAmount;
    //维修申请0未撤销1维修申请撤销
    private int IsRevocation;

    @Override
    public String toString() {
        return "Maintainlist{" +
                "ID=" + ID +
                ", UserID=" + UserID +
                ", Name='" + Name + '\'' +
                ", IsAllow=" + IsAllow +
                ", MaintainCause='" + MaintainCause + '\'' +
                ", State=" + State +
                ", DeleteFlag=" + DeleteFlag +
                ", VehicleID=" + VehicleID +
                ", PlateNumber='" + PlateNumber + '\'' +
                ", MaintainDate=" + MaintainDate +
                ", MaintenanceAmount=" + MaintenanceAmount +
                ", IsRevocation=" + IsRevocation +
                '}';
    }

    public int getIsRevocation() {
        return IsRevocation;
    }

    public void setIsRevocation(int isRevocation) {
        IsRevocation = isRevocation;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPlateNumber() {
        return PlateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        PlateNumber = plateNumber;
    }

    public String getMaintainCause() {
        return MaintainCause;
    }

    public void setMaintainCause(String maintainCause) {
        MaintainCause = maintainCause;
    }

    public Timestamp getMaintainDate() {
        return MaintainDate;
    }

    public void setMaintainDate(Timestamp maintainDate) {
        MaintainDate = maintainDate;
    }

    public int getMaintenanceAmount() {
        return MaintenanceAmount;
    }

    public void setMaintenanceAmount(int maintenanceAmount) {
        MaintenanceAmount = maintenanceAmount;
    }

    public int getVehicleID() {
        return VehicleID;
    }

    public void setVehicleID(int vehicleID) {
        VehicleID = vehicleID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getIsAllow() {
        return IsAllow;
    }

    public void setIsAllow(int isAllow) {
        IsAllow = isAllow;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }

    public int getDeleteFlag() {
        return DeleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        DeleteFlag = deleteFlag;
    }

}
