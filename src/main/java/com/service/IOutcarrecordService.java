package com.service;

import com.model.Maintain;
import com.model.Outcarrecord;
import com.model.Outcarrecordlist;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IOutcarrecordService {
    List<Outcarrecordlist> getalllist();

    List<Outcarrecordlist> getIsAllowlist();

    Outcarrecord selectoutcarrecordbyuserID(int userID);

    int addoutcarrecord(Outcarrecord outcarrecord);

    Outcarrecord selectoutcarrecordbyvehicleID(int vehicleID);

    Outcarrecord selectoutcarrecordbyID(int ID);

    int deleteoutcarrecord(int ID);

    int revocationoutcarrecord(int ID);

    int outcarrecordIsAllow(@Param("ID") int ID,@Param("IsAllow") int IsAllow);

    List<Outcarrecordlist> getIsRevocation();

    List<Outcarrecordlist> getalllistbyid(int UserID);

    List<Outcarrecordlist> getIsAllowbyid(int UserID, int ISAllow);

    List<Outcarrecordlist> getIsRevocationbyid(int UserID);

    int updateoutcarrecord(Outcarrecord outcarrecord);

    int outcarrecordState(int ID,int State);

    List<Outcarrecordlist> getstatebyid(int userID);

    List<Outcarrecord> selectstatebyUserID(int userID);

    List<Outcarrecord> selectstatebyVehiclevID(int vehicleID);
}
