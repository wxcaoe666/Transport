package com.service;

import com.model.Violation;
import com.model.Violationlist;

import java.util.List;

public interface IViolationService {
    List<Violationlist> getalllist();

    int addviolation(Violation violation);

    int deleteviolation(int ID);

    List<Violationlist> getalllistbyid(int UserID);

    Violation selectviolationbyID(int ID);

    int updateviolation(Violation violation);
}
