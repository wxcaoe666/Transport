package com.service;

import com.model.Maintain;
import com.model.Maintainlist;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IMaintainService {
    List<Maintainlist> getalllist();

    List<Maintainlist> getIsAllowlist();

    int addmaintain(Maintain maintain);

    int deletemaintain(int ID);

    Maintain selectmaintainbyID(int ID);

    int revocationmaintain(int ID);

    int maintainIsAllow(int ID, int IsAllow);

    List<Maintainlist> getIsRevocationlist();

    List<Maintainlist> getalllistbyid(int UserID);

    List<Maintainlist> getIsAllowbyid(int UserID, int IsAllow);

    List<Maintainlist> getIsRevocationbyid(int UserID);

    int updatemaintain(Maintain maintain);
}
