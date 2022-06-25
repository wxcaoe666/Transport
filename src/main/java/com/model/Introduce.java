package com.model;

public class Introduce {

    private int ID;

    private int UserID;

    private String IntroOne;

    private String IntroTwo;

    private String IntroThree;

    private String IntroFour;

    private String IntroFive;

    private String IntroSix;

    private String IntroSeven;

    private String IntroEight;

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

    public String getIntroOne() {
        return IntroOne;
    }

    public void setIntroOne(String introOne) {
        IntroOne = introOne;
    }

    public String getIntroTwo() {
        return IntroTwo;
    }

    public void setIntroTwo(String introTwo) {
        IntroTwo = introTwo;
    }

    public String getIntroThree() {
        return IntroThree;
    }

    public void setIntroThree(String introThree) {
        IntroThree = introThree;
    }

    public String getIntroFour() {
        return IntroFour;
    }

    public void setIntroFour(String introFour) {
        IntroFour = introFour;
    }

    public String getIntroFive() {
        return IntroFive;
    }

    public void setIntroFive(String introFive) {
        IntroFive = introFive;
    }

    public String getIntroSix() {
        return IntroSix;
    }

    public void setIntroSix(String introSix) {
        IntroSix = introSix;
    }

    public String getIntroSeven() {
        return IntroSeven;
    }

    public void setIntroSeven(String introSeven) {
        IntroSeven = introSeven;
    }

    public String getIntroEight() {
        return IntroEight;
    }

    public void setIntroEight(String introEight) {
        IntroEight = introEight;
    }

    @Override
    public String toString() {
        return "Introduce{" +
                "ID=" + ID +
                ", UserID=" + UserID +
                ", IntroOne='" + IntroOne + '\'' +
                ", IntroTwo='" + IntroTwo + '\'' +
                ", IntroThree='" + IntroThree + '\'' +
                ", IntroFour='" + IntroFour + '\'' +
                ", IntroFive='" + IntroFive + '\'' +
                ", IntroSix='" + IntroSix + '\'' +
                ", IntroSeven='" + IntroSeven + '\'' +
                ", IntroEight='" + IntroEight + '\'' +
                '}';
    }
}
