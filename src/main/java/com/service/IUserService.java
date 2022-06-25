package com.service;

import com.model.HeadPortraits;
import com.model.User;
import com.model.Userselect;

import java.util.List;

public interface IUserService {
    int addUser(User user);

    int updateUser(User user);

    User selectUser(String UserName);

    int deleteUser(String UserName);

    User login(String UserName, String Password);

    int register(User user);

    List<User> getlist(Userselect name);

    User selectuserbyID(int ID);

    int updateRole(User user);

    HeadPortraits selectheadportraitsbyUserID(int UsreID);

    int addheadportraits(HeadPortraits headPortraits);

    int updateheadportraits(HeadPortraits headPortraits);
}
