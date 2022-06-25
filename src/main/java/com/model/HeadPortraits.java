package com.model;

import java.util.Arrays;

public class HeadPortraits {

    private int ID;

    private int UserID;

    private byte[] Picture;

    @Override
    public String toString() {
        return "HeadPortraits{" +
                "ID=" + ID +
                ", UserID=" + UserID +
                ", Picture=" + Arrays.toString(Picture) +
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

    public byte[] getPicture() {
        return Picture;
    }

    public void setPicture(byte[] picture) {
        Picture = picture;
    }
}
