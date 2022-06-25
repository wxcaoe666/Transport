package com.model;

import java.sql.Timestamp;

public class Violationlist {

    //出车记录id
    private int ID;
    //车辆当前使用者id
    private int UserID;
    //用户姓名
    private String Name;
    //违章原因
    private String ViolationCause;
    //是否删除0未，1已删除
    private int DeleteFlag;
    //运输车辆id
    private int VehicleID;
    //车牌号
    private String PlateNumber;
    //违章时间
    private Timestamp ViolationDate;
    //违章记录创建时间
    private Timestamp CreateDate;
    //罚款金额
    private int Forfeit;

    @Override
    public String toString() {
        return "Violationlist{" +
                "ID=" + ID +
                ", UserID=" + UserID +
                ", Name='" + Name + '\'' +
                ", ViolationCause='" + ViolationCause + '\'' +
                ", DeleteFlag=" + DeleteFlag +
                ", VehicleID=" + VehicleID +
                ", PlateNumber='" + PlateNumber + '\'' +
                ", ViolationDate=" + ViolationDate +
                ", CreateDate=" + CreateDate +
                ", Forfeit=" + Forfeit +
                '}';
    }

    public Timestamp getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Timestamp createDate) {
        CreateDate = createDate;
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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getViolationCause() {
        return ViolationCause;
    }

    public void setViolationCause(String violationCause) {
        ViolationCause = violationCause;
    }

    public int getDeleteFlag() {
        return DeleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        DeleteFlag = deleteFlag;
    }

    public int getVehicleID() {
        return VehicleID;
    }

    public void setVehicleID(int vehicleID) {
        VehicleID = vehicleID;
    }

    public String getPlateNumber() {
        return PlateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        PlateNumber = plateNumber;
    }

    public Timestamp getViolationDate() {
        return ViolationDate;
    }

    public void setViolationDate(Timestamp violationDate) {
        ViolationDate = violationDate;
    }

    public int getForfeit() {
        return Forfeit;
    }

    public void setForfeit(int forfeit) {
        Forfeit = forfeit;
    }

}
