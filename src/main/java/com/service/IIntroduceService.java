package com.service;

import com.model.Introduce;

public interface IIntroduceService {
    Introduce getintroducebyuserid(int USerID);

    int addintroducen(Introduce introduce);

    int updateintroduce(Introduce introduce);
}
