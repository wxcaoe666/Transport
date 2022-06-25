package com.service.Impl;

import com.dao.IViolationDao;
import com.model.Violation;
import com.model.Violationlist;
import com.service.IViolationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ViolationServiceimpl implements IViolationService {

    @Resource
    private IViolationDao violationDao;
    @Override
    public List<Violationlist> getalllist() {
        return violationDao.getalllist();
    }

    @Override
    public int addviolation(Violation violation) {
        return violationDao.addviolation(violation);
    }

    @Override
    public int deleteviolation(int ID) {
        return violationDao.deleteviolation(ID);
    }

    @Override
    public List<Violationlist> getalllistbyid(int UserID) {
        return violationDao.getalllistbyid(UserID);
    }

    @Override
    public Violation selectviolationbyID(int ID) {
        return violationDao.selectviolationbyID(ID);
    }

    @Override
    public int updateviolation(Violation violation) {
        return violationDao.updateviolation(violation);
    }
}
