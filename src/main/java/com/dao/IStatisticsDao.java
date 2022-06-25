package com.dao;

import com.model.Count;
import com.model.Month;
import com.model.MonthCount;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface IStatisticsDao {

    Count getcount(@Param("starttime") Date starttime,@Param("endtime") Date endtime);

    MonthCount getmonthcount1(Month month);

    MonthCount getmonthcount2(Month month);

    MonthCount getmonthcount3(Month month);

    MonthCount getmonthcount4(Month month);

}
