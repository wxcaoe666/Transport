package com.controller;

import com.model.Count;
import com.model.Month;
import com.model.MonthCount;
import com.service.IStatisticsService;
import com.utils.TimeFn;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Resource
    private IStatisticsService statisticsService;

    /**
     * 获取本年内所有用户记录总数
     *
     * @return
     */
    @RequestMapping(value = "/getcount", method = RequestMethod.GET)
    @ResponseBody
    public Count getcount() {
        Date beginDayOfYear = TimeFn.getBeginDayOfYear();
        Date endDayOfYear = TimeFn.getEndDayOfYear();
        return statisticsService.getcount(beginDayOfYear, endDayOfYear);
    }

    /**
     * 出车、维修、违章、事故
     * 获取本年内每月的用户事件记录总数
     *
     * @return
     */
    @RequestMapping(value = "/getmonthcount", method = RequestMethod.GET)
    @ResponseBody
    public List<int[]> getmonthcount() throws Exception {

        List<Timestamp> monthStr = TimeFn.getMonthStr();
        Date endDayOfYear = TimeFn.getEndDayOfYear();
        Month month = new Month();
        month.setJan(monthStr.get(0));
        month.setFeb(monthStr.get(1));
        month.setMar(monthStr.get(2));
        month.setApr(monthStr.get(3));
        month.setMay(monthStr.get(4));
        month.setJun(monthStr.get(5));
        month.setJul(monthStr.get(6));
        month.setAug(monthStr.get(7));
        month.setSep(monthStr.get(8));
        month.setOct(monthStr.get(9));
        month.setNov(monthStr.get(10));
        month.setDec(monthStr.get(11));
        month.setEndDec((Timestamp) endDayOfYear);
        //出车
        MonthCount monthCount1 = statisticsService.getmonthcount1(month);
        int[] int1=new int[12];
        int1[0]=monthCount1.getJanCount();
        int1[1]=monthCount1.getFebCount();
        int1[2]=monthCount1.getMarCount();
        int1[3]=monthCount1.getAprCount();
        int1[4]=monthCount1.getMayCount();
        int1[5]=monthCount1.getJunCount();
        int1[6]=monthCount1.getJulCount();
        int1[7]=monthCount1.getAugCount();
        int1[8]=monthCount1.getSepCount();
        int1[9]=monthCount1.getOctCount();
        int1[10]=monthCount1.getNovCount();
        int1[11]=monthCount1.getDecCount();
        //维修
        MonthCount monthCount2 = statisticsService.getmonthcount2(month);
        int[] int2=new int[12];
        int2[0]=monthCount2.getJanCount();
        int2[1]=monthCount2.getFebCount();
        int2[2]=monthCount2.getMarCount();
        int2[3]=monthCount2.getAprCount();
        int2[4]=monthCount2.getMayCount();
        int2[5]=monthCount2.getJunCount();
        int2[6]=monthCount2.getJulCount();
        int2[7]=monthCount2.getAugCount();
        int2[8]=monthCount2.getSepCount();
        int2[9]=monthCount2.getOctCount();
        int2[10]=monthCount2.getNovCount();
        int2[11]=monthCount2.getDecCount();
        //违章
        MonthCount monthCount3 = statisticsService.getmonthcount3(month);
        int[] int3=new int[12];
        int3[0]=monthCount3.getJanCount();
        int3[1]=monthCount3.getFebCount();
        int3[2]=monthCount3.getMarCount();
        int3[3]=monthCount3.getAprCount();
        int3[4]=monthCount3.getMayCount();
        int3[5]=monthCount3.getJunCount();
        int3[6]=monthCount3.getJulCount();
        int3[7]=monthCount3.getAugCount();
        int3[8]=monthCount3.getSepCount();
        int3[9]=monthCount3.getOctCount();
        int3[10]=monthCount3.getNovCount();
        int3[11]=monthCount3.getDecCount();
        //事故
        MonthCount monthCount4 = statisticsService.getmonthcount4(month);
        int[] int4=new int[12];
        int4[0]=monthCount4.getJanCount();
        int4[1]=monthCount4.getFebCount();
        int4[2]=monthCount4.getMarCount();
        int4[3]=monthCount4.getAprCount();
        int4[4]=monthCount4.getMayCount();
        int4[5]=monthCount4.getJunCount();
        int4[6]=monthCount4.getJulCount();
        int4[7]=monthCount4.getAugCount();
        int4[8]=monthCount4.getSepCount();
        int4[9]=monthCount4.getOctCount();
        int4[10]=monthCount4.getNovCount();
        int4[11]=monthCount4.getDecCount();

        List<int[]> list=new ArrayList<int[]>();
        list.add(0,int1);
        list.add(1,int2);
        list.add(2,int3);
        list.add(3,int4);

        return list;
    }

}
