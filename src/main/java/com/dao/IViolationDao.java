package com.dao;

import com.model.Maintain;
import com.model.Violation;
import com.model.Violationlist;

import java.util.List;

public interface IViolationDao {
    List<Violationlist> getalllist();

    int addviolation(Violation violation);

    int deleteviolation(int ID);

    List<Violationlist> getalllistbyid(int UserID);

    Violation selectviolationbyID(int ID);

    int updateviolation(Violation violation);
}
