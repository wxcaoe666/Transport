package com.service.Impl;

import com.dao.IStatisticsDao;
import com.model.Count;
import com.model.Month;
import com.model.MonthCount;
import com.service.IStatisticsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class StatisticsServiceimpl implements IStatisticsService {

    @Resource
    private IStatisticsDao statisticsDao;

    @Override
    public Count getcount(Date starttime,Date endtime) {
        return statisticsDao.getcount( starttime,endtime);
    }

    @Override
    public MonthCount getmonthcount1(Month month) {
        return statisticsDao.getmonthcount1(month);
    }

    @Override
    public MonthCount getmonthcount2(Month month) {
        return statisticsDao.getmonthcount2(month);
    }

    @Override
    public MonthCount getmonthcount3(Month month) {
        return statisticsDao.getmonthcount3(month);
    }

    @Override
    public MonthCount getmonthcount4(Month month) {
        return statisticsDao.getmonthcount4(month);
    }
}
