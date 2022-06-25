package com.dao;

import com.model.HeadPortraits;
import com.model.User;
import com.model.Userselect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserDao {
    int addUser(User user);

    int updateUser(User user);

    User selectUser(@Param("UserName") String UserName);

    int deleteUser(String UserName);

    User login(@Param("UserName") String UserName, @Param("Password") String Password);

    int register(User user);

    List<User> getlist(Userselect userselect);

    User selectuserbyID(int ID);

    int updateRole(User user);

    HeadPortraits selectheadportraitsbyUserID(int UsreID);

    int addheadportraits(HeadPortraits headPortraits);

    int updateheadportraits(HeadPortraits headPortraits);
}
