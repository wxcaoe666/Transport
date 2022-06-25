package com.service.Impl;

import com.dao.IIntroduceDao;
import com.model.Introduce;
import com.service.IIntroduceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Introduceimpl implements IIntroduceService {

    @Resource
    private IIntroduceDao introduceDao;

    @Override
    public Introduce getintroducebyuserid(int USerID) {
        return introduceDao.getintroducebyuserid(USerID);
    }

    @Override
    public int addintroducen(Introduce introduce) {
        return introduceDao.addintroducen(introduce);
    }

    @Override
    public int updateintroduce(Introduce introduce) {
        return introduceDao.updateintroduce(introduce);
    }
}
