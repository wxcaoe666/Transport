package com.service.Impl;

import com.dao.IUserDao;
import com.model.HeadPortraits;
import com.model.User;
import com.model.Userselect;
import com.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceimpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User selectUser(String UserName) {
        return userDao.selectUser(UserName);
    }

    @Override
    public int deleteUser(String UserName) {
        return 0;
    }

    @Override
    public User login(String UserName, String Password) {
        return  userDao.login(UserName, Password);
    }

    @Override
    public int register(User user) {
        return userDao.register(user);
    }

    @Override
    public List<User> getlist(Userselect userselect) {
        return userDao.getlist(userselect);
    }

    @Override
    public User selectuserbyID(int ID) {
        return userDao.selectuserbyID(ID);
    }

    @Override
    public int updateRole(User user) {
        return userDao.updateRole(user);
    }

    @Override
    public HeadPortraits selectheadportraitsbyUserID(int UsreID) {
        return userDao.selectheadportraitsbyUserID(UsreID);
    }

    @Override
    public int addheadportraits(HeadPortraits headPortraits) {
        return userDao.addheadportraits(headPortraits);
    }
    @Override
    public int updateheadportraits(HeadPortraits headPortraits) {
        return userDao.updateheadportraits(headPortraits);
    }

}
