package com.service.Impl;

import com.dao.IMaintainDao;
import com.model.Maintain;
import com.model.Maintainlist;
import com.service.IMaintainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MaintainServiceimpl implements IMaintainService {

    @Resource
    private IMaintainDao maintainDao;

    @Override
    public List<Maintainlist> getalllist() {
        return maintainDao.getalllist();
    }

    @Override
    public List<Maintainlist> getIsAllowlist() {
        return  maintainDao.getIsAllowlist();
    }

    @Override
    public int addmaintain(Maintain maintain) {
        return maintainDao.addmaintain(maintain);
    }

    @Override
    public int deletemaintain(int ID) {
        return maintainDao.deletemaintain(ID);
    }

    @Override
    public Maintain selectmaintainbyID(int ID) {
        return maintainDao.selectmaintainbyID(ID);
    }

    @Override
    public int revocationmaintain(int ID) {
        return maintainDao.revocationmaintain(ID);
    }

    @Override
    public int maintainIsAllow(int ID, int IsAllow) {
        return maintainDao.maintainIsAllow(ID,IsAllow);
    }

    @Override
    public List<Maintainlist> getIsRevocationlist() {
        return maintainDao.getIsRevocationlist();
    }

    @Override
    public List<Maintainlist> getalllistbyid(int UserID) {
        return maintainDao.getalllistbyid(UserID);
    }

    @Override
    public List<Maintainlist> getIsAllowbyid(int UserID, int IsAllow) {
        return maintainDao.getIsAllowbyid(UserID,IsAllow);
    }

    @Override
    public List<Maintainlist> getIsRevocationbyid(int UserID) {
        return maintainDao.getIsRevocationbyid(UserID);
    }

    @Override
    public int updatemaintain(Maintain maintain) {
        return maintainDao.updatemaintain(maintain);
    }
}
