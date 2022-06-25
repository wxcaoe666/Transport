package com.model;

import java.sql.Timestamp;

public class Month {

    //一月
    private Timestamp Jan;
    //二月
    private Timestamp Feb;
    //三月
    private Timestamp Mar;
    //四月
    private Timestamp Apr;
    //五月
    private Timestamp May;
    //六月
    private Timestamp Jun;
    //七月
    private Timestamp Jul;
    //八月
    private Timestamp Aug;
    //九月
    private Timestamp Sep;
    //十月
    private Timestamp Oct;
    //十一月
    private Timestamp Nov;
    //十二月
    private Timestamp Dec;
    //十二月结束
    private Timestamp EndDec;

    @Override
    public String toString() {
        return "Month{" +
                "Jan=" + Jan +
                ", Feb=" + Feb +
                ", Mar=" + Mar +
                ", Apr=" + Apr +
                ", May=" + May +
                ", Jun=" + Jun +
                ", Jul=" + Jul +
                ", Aug=" + Aug +
                ", Sep=" + Sep +
                ", Oct=" + Oct +
                ", Nov=" + Nov +
                ", Dec=" + Dec +
                ", EndDec=" + EndDec +
                '}';
    }

    public Timestamp getEndDec() {
        return EndDec;
    }

    public void setEndDec(Timestamp endDec) {
        EndDec = endDec;
    }

    public Timestamp getJan() {
        return Jan;
    }

    public void setJan(Timestamp jan) {
        Jan = jan;
    }

    public Timestamp getFeb() {
        return Feb;
    }

    public void setFeb(Timestamp feb) {
        Feb = feb;
    }

    public Timestamp getMar() {
        return Mar;
    }

    public void setMar(Timestamp mar) {
        Mar = mar;
    }

    public Timestamp getApr() {
        return Apr;
    }

    public void setApr(Timestamp apr) {
        Apr = apr;
    }

    public Timestamp getMay() {
        return May;
    }

    public void setMay(Timestamp may) {
        May = may;
    }

    public Timestamp getJun() {
        return Jun;
    }

    public void setJun(Timestamp jun) {
        Jun = jun;
    }

    public Timestamp getJul() {
        return Jul;
    }

    public void setJul(Timestamp jul) {
        Jul = jul;
    }

    public Timestamp getAug() {
        return Aug;
    }

    public void setAug(Timestamp aug) {
        Aug = aug;
    }

    public Timestamp getSep() {
        return Sep;
    }

    public void setSep(Timestamp sep) {
        Sep = sep;
    }

    public Timestamp getOct() {
        return Oct;
    }

    public void setOct(Timestamp oct) {
        Oct = oct;
    }

    public Timestamp getNov() {
        return Nov;
    }

    public void setNov(Timestamp nov) {
        Nov = nov;
    }

    public Timestamp getDec() {
        return Dec;
    }

    public void setDec(Timestamp dec) {
        Dec = dec;
    }

}
