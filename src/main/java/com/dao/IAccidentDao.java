package com.dao;

import com.model.Accident;
import com.model.Accidentlist;

import java.util.List;

public interface IAccidentDao {
    List<Accidentlist> getalllist();

    int addaccident(Accident accident);

    int deleteaccident(int ID);

    List<Accidentlist> getalllistbyid(int UserID);

    Accident selectaccidentbyID(int ID);

    int updateaccident(Accident accident);
}
