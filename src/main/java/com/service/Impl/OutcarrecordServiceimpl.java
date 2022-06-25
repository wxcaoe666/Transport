package com.service.Impl;

import com.dao.IOutcarrecordDao;
import com.model.Maintain;
import com.model.Outcarrecord;
import com.model.Outcarrecordlist;
import com.service.IOutcarrecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OutcarrecordServiceimpl implements IOutcarrecordService {

    @Resource
    private IOutcarrecordDao outcarrecordDao;

    @Override
    public List<Outcarrecordlist> getalllist() {
        return outcarrecordDao.getalllist();
    }

    @Override
    public List<Outcarrecordlist> getIsAllowlist() {
        return  outcarrecordDao.getIsAllowlist();
    }

    @Override
    public Outcarrecord selectoutcarrecordbyuserID(int userID) {
        return outcarrecordDao.selectoutcarrecordbyuserID(userID);
    }

    @Override
    public int addoutcarrecord(Outcarrecord outcarrecord) {
        return outcarrecordDao.addoutcarrecord(outcarrecord);
    }

    @Override
    public Outcarrecord selectoutcarrecordbyvehicleID(int vehicleID) {
        return outcarrecordDao.selectoutcarrecordbyvehicleID(vehicleID);
    }

    @Override
    public Outcarrecord selectoutcarrecordbyID(int ID) {
        return outcarrecordDao.selectoutcarrecordbyID(ID);
    }

    @Override
    public int deleteoutcarrecord(int ID) {
        return outcarrecordDao.deleteoutcarrecord(ID);
    }

    @Override
    public int revocationoutcarrecord(int ID) {
        return outcarrecordDao.revocationoutcarrecord(ID);
    }

    @Override
    public int outcarrecordIsAllow(int ID, int IsAllow) {
        return outcarrecordDao.outcarrecordIsAllow(ID,IsAllow);
    }

    @Override
    public List<Outcarrecordlist> getIsRevocation() {
        return outcarrecordDao.getIsRevocation();
    }

    @Override
    public List<Outcarrecordlist> getalllistbyid(int UserID) {
        return outcarrecordDao.getalllistbyid(UserID);
    }

    @Override
    public List<Outcarrecordlist> getIsAllowbyid(int UserID, int ISAllow) {
        return outcarrecordDao.getIsAllowbyid( UserID, ISAllow);
    }

    @Override
    public List<Outcarrecordlist> getIsRevocationbyid(int UserID) {
        return outcarrecordDao.getIsRevocationbyid(UserID);
    }

    @Override
    public int updateoutcarrecord(Outcarrecord outcarrecord) {
        return outcarrecordDao.updateoutcarrecord(outcarrecord);
    }

    @Override
    public int outcarrecordState(int ID, int State) {
        return outcarrecordDao.outcarrecordState(ID,State);
    }

    @Override
    public List<Outcarrecordlist> getstatebyid(int userID) {
        return outcarrecordDao.getstatebyid(userID);
    }

    @Override
    public List<Outcarrecord> selectstatebyUserID(int userID) {
        return outcarrecordDao.selectstatebyUserID(userID);
    }

    @Override
    public List<Outcarrecord> selectstatebyVehiclevID(int vehicleID) {
        return outcarrecordDao.selectstatebyVehiclevID(vehicleID);
    }
}
