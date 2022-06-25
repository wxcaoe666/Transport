package com.model;

import java.sql.Timestamp;

public class Outcarrecord {

    //出车记录id
    private int ID;
    //车辆当前使用者id
    private int UserID;
    //是否允许出车0不允许1允许
    private int IsAllow;
    //出车地址
    private String StartingAddress;
    //终点地址
    private String DestinationAddress;
    //状态0未开始1进行中2结束
    private int State;
    //是否删除0未，1已删除
    private int DeleteFlag;
    //运输车辆id
    private int VehicleID;
    //出车申请创建时间
    private Timestamp CreateDate;
    //出车申请0未撤销1维修申请撤销
    private int IsRevocation;

    @Override
    public String toString() {
        return "Outcarrecord{" +
                "ID=" + ID +
                ", UserID=" + UserID +
                ", IsAllow=" + IsAllow +
                ", StartingAddress='" + StartingAddress + '\'' +
                ", DestinationAddress='" + DestinationAddress + '\'' +
                ", State=" + State +
                ", DeleteFlag=" + DeleteFlag +
                ", VehicleID=" + VehicleID +
                ", CreateDate=" + CreateDate +
                ", IsRevocation=" + IsRevocation +
                '}';
    }

    public int getIsRevocation() {
        return IsRevocation;
    }

    public void setIsRevocation(int isRevocation) {
        IsRevocation = isRevocation;
    }

    public Timestamp getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Timestamp createDate) {
        CreateDate = createDate;
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

    public String getStartingAddress() {
        return StartingAddress;
    }

    public void setStartingAddress(String startingAddress) {
        StartingAddress = startingAddress;
    }

    public String getDestinationAddress() {
        return DestinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        DestinationAddress = destinationAddress;
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
