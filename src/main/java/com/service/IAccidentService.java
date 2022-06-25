package com.service;

import com.model.Accident;
import com.model.Accidentlist;

import java.util.List;

public interface IAccidentService {
    List<Accidentlist> getalllist();

    int addaccident(Accident accident);

    int deleteaccident(int ID);

    List<Accidentlist> getalllistbyid(int UserID);

    Accident selectaccidentbyID(int ID);

    int updateaccident(Accident accident);

}
