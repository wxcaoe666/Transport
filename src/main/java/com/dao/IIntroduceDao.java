package com.dao;

import com.model.Introduce;

public interface IIntroduceDao {
    Introduce getintroducebyuserid(int UserID);

    int addintroducen(Introduce introduce);

    int updateintroduce(Introduce introduce);
}
