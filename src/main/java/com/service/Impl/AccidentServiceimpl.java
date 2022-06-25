package com.service.Impl;

import com.dao.IAccidentDao;
import com.model.Accident;
import com.model.Accidentlist;
import com.service.IAccidentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccidentServiceimpl implements IAccidentService {

    @Resource
    private IAccidentDao accidentDao;

    @Override
    public List<Accidentlist> getalllist() {
        return accidentDao.getalllist();
    }

    @Override
    public int addaccident(Accident accident) {
        return accidentDao.addaccident(accident);
    }

    @Override
    public int deleteaccident(int ID) {
        return accidentDao.deleteaccident(ID);
    }

    @Override
    public List<Accidentlist> getalllistbyid(int UserID) {
        return accidentDao.getalllistbyid(UserID);
    }

    @Override
    public Accident selectaccidentbyID(int ID)  {
        return  accidentDao.selectaccidentbyID(ID);
    }

    @Override
    public int updateaccident(Accident accident) {
        return accidentDao.updateaccident(accident);
    }
}
