package com.service;

import com.model.Count;
import com.model.Month;
import com.model.MonthCount;

import java.util.Date;

public interface IStatisticsService {

    Count getcount(Date starttime, Date endtime);

    MonthCount getmonthcount1(Month month);

    MonthCount getmonthcount2(Month month);

    MonthCount getmonthcount3(Month month);

    MonthCount getmonthcount4(Month month);


}
