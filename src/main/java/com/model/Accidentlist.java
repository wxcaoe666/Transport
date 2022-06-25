package com.model;

import java.sql.Timestamp;

public class Accidentlist {

    //事故记录ID
    private int ID;
    //事故用户ID
    private int UserID;
    //事故车辆ID
    private int VehicleID;
    //事故发生时间
    private Timestamp AccidentDate;
    //事故损失金额
    private int LossAmount;
    //事故发生原因
    private String AccidentCause;
    //事故处理结果
    private String AccidentResult;
    //事故记录创建时间ID
    private Timestamp CreateDate;
    //0未删除，1已删除
    private int DeleteFlag;
    //用户姓名
    private String Name;
    //车牌号
    private String PlateNumber;
    //事故发生地址
    private String AccidentAddress;

    public String getAccidentAddress() {
        return AccidentAddress;
    }

    public void setAccidentAddress(String accidentAddress) {
        AccidentAddress = accidentAddress;
    }

    @Override
    public String toString() {
        return "Accidentlist{" +
                "ID=" + ID +
                ", UserID=" + UserID +
                ", VehicleID=" + VehicleID +
                ", AccidentDate=" + AccidentDate +
                ", LossAmount=" + LossAmount +
                ", AccidentCause='" + AccidentCause + '\'' +
                ", AccidentResult='" + AccidentResult + '\'' +
                ", CreateDate=" + CreateDate +
                ", DeleteFlag=" + DeleteFlag +
                ", Name='" + Name + '\'' +
                ", PlateNumber='" + PlateNumber + '\'' +
                ", AccidentAddress='" + AccidentAddress + '\'' +
                '}';
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

    public int getVehicleID() {
        return VehicleID;
    }

    public void setVehicleID(int vehicleID) {
        VehicleID = vehicleID;
    }

    public Timestamp getAccidentDate() {
        return AccidentDate;
    }

    public void setAccidentDate(Timestamp accidentDate) {
        AccidentDate = accidentDate;
    }

    public int getLossAmount() {
        return LossAmount;
    }

    public void setLossAmount(int lossAmount) {
        LossAmount = lossAmount;
    }

    public String getAccidentCause() {
        return AccidentCause;
    }

    public void setAccidentCause(String accidentCause) {
        AccidentCause = accidentCause;
    }

    public String getAccidentResult() {
        return AccidentResult;
    }

    public void setAccidentResult(String accidentResult) {
        AccidentResult = accidentResult;
    }

    public Timestamp getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Timestamp createDate) {
        CreateDate = createDate;
    }

    public int getDeleteFlag() {
        return DeleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        DeleteFlag = deleteFlag;
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
}
