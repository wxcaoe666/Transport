package com.model;

import java.lang.String;
import java.sql.Timestamp;

public class User {

    //id
    private int ID;
    //用户名
    private String UserName;
    //姓名
    private String Name;
    //姓名
    private int Age;
    //密码
    private String Password;
    //创建时间
    private Timestamp CreateTime;
    //电话
    private long Phone;
    /**权限
     * admin管理员
     * common普通用户
     */
    private String Role;

    //删除标记，0未删除，1已删除

    private int DeleteFlag;
    //guid
    private String Guid;
    //guid
    private String Email;
    //性别0未知，1男，2女
    private int Sex;

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Timestamp getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Timestamp createTime) {
        CreateTime = createTime;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public int getDeleteFlag() {
        return DeleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        DeleteFlag = deleteFlag;
    }

    public String getGuid() {
        return Guid;
    }

    public void setGuid(String guid) {
        Guid = guid;
    }

    public int getSex() {
        return Sex;
    }

    public void setSex(int sex) {
        Sex = sex;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public long getPhone() {
        return Phone;
    }

    public void setPhone(long phone) {
        Phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", UserName='" + UserName + '\'' +
                ", Name='" + Name + '\'' +
                ", Age=" + Age +
                ", Password='" + Password + '\'' +
                ", CreateTime=" + CreateTime +
                ", Phone=" + Phone +
                ", Role='" + Role + '\'' +
                ", DeleteFlag=" + DeleteFlag +
                ", Guid='" + Guid + '\'' +
                ", Email='" + Email + '\'' +
                ", Sex=" + Sex +
                '}';
    }
}
