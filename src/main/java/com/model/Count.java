package com.model;

public class Count {
    //事故记录总数
    private int AccidentCount;
    //维修记录总数
    private int MaintainCount;
    //违章记录总数
    private int ViolationCount;
    //出车记录总数
    private int OutcarrecordCount;

    @Override
    public String toString() {
        return "Count{" +
                "AccidentCount=" + AccidentCount +
                ", MaintainCount=" + MaintainCount +
                ", ViolationCount=" + ViolationCount +
                ", OutcarrecordCount=" + OutcarrecordCount +
                '}';
    }

    public int getAccidentCount() {
        return AccidentCount;
    }

    public void setAccidentCount(int accidentCount) {
        AccidentCount = accidentCount;
    }

    public int getMaintainCount() {
        return MaintainCount;
    }

    public void setMaintainCount(int maintainCount) {
        MaintainCount = maintainCount;
    }

    public int getViolationCount() {
        return ViolationCount;
    }

    public void setViolationCount(int violationCount) {
        ViolationCount = violationCount;
    }

    public int getOutcarrecordCount() {
        return OutcarrecordCount;
    }

    public void setOutcarrecordCount(int outcarrecordCount) {
        OutcarrecordCount = outcarrecordCount;
    }
}
