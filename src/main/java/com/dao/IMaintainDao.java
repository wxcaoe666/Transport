package com.dao;

import com.model.Maintain;
import com.model.Maintainlist;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IMaintainDao {
    List<Maintainlist> getalllist();

    List<Maintainlist> getIsAllowlist();

    int addmaintain(Maintain maintain);

    int deletemaintain(int ID);

    Maintain selectmaintainbyID(int ID);

    int revocationmaintain(int ID);

    int maintainIsAllow(@Param("ID") int ID, @Param("IsAllow")int IsAllow);

    List<Maintainlist> getIsRevocationlist();

    List<Maintainlist> getalllistbyid(int UserID);

    List<Maintainlist> getIsAllowbyid(@Param("UserID") int UserID, @Param("IsAllow")int IsAllow);

    List<Maintainlist> getIsRevocationbyid(int UserID);

    int updatemaintain(Maintain maintain);
}
