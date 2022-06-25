package Test;

import com.controller.StatisticsController;
import com.dao.IOutcarrecordDao;
import com.dao.IStatisticsDao;
import com.dao.IUserDao;
import com.dao.IVehicleDao;
import com.model.*;
import com.service.IMaintainService;
import com.service.IUserService;
import com.utils.TimeFn;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class Test1 {

    @Autowired
    private IMaintainService maintainService;

    @Test
    public void test3() {
        int i = maintainService.maintainIsAllow(2, 1);
        System.out.println(i);
    }

    @Autowired
    private IUserService userService;

    @Test
    public void testuser() {
        User user = new User();
        user.setID(7);
        user.setAge(24);
        user.setSex(2);
        user.setEmail("4083305095@qq.com");
        user.setPhone(1270758739);
        user.setName("小孙");
        user.setPassword("1234567");
        user.setUserName("xiaosun");
        int i = userService.updateUser(user);
        System.out.println(i);

    }

    @Autowired
    private IUserDao dao;

    @Autowired
    private IVehicleDao vehicleDao;

    @Autowired
    private IOutcarrecordDao outcarrecordDao;

    @Test
    public void testSelectUser() throws Exception {
        User user = dao.selectUser("admin");
        String s = user.toString();
        System.out.println(s);
    }

    @Test
    public void testlogin() throws Exception {

        User login = dao.login("admin", "root");
        if (login != null) {
            System.out.println("存在该用户");
        }
    }

    @Test
    public void testlist() throws Exception {
        List<User> list = dao.getlist(new Userselect());
        System.out.println(list);
    }


    @Test
    public void testlist2() throws Exception {
        List<Outcarrecordlist> list = outcarrecordDao.getalllist();
        System.out.println(list);
    }

    @Autowired
    private IStatisticsDao statisticsDao;

    @Test
    public void testcount() {
        Date beginDayOfYear = TimeFn.getBeginDayOfYear();
        Date endDayOfYear = TimeFn.getEndDayOfYear();
        Count count = statisticsDao.getcount(beginDayOfYear,endDayOfYear);
        System.out.println(count);
        System.out.println(beginDayOfYear);
        System.out.println(endDayOfYear);
    }

    @Test
    public void testcount1() throws ParseException {

        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timeStamp);
        long time = timeStamp.getTime();
        System.out.println(time);
        Date date=new Date(time);
        System.out.println(date);
        System.out.println("////////////////");
        Date beginDayOfYear = TimeFn.getBeginDayOfYear();
        System.out.println(beginDayOfYear);
        Timestamp timeStamp1 = new Timestamp( beginDayOfYear.getTime());
        System.out.println(timeStamp1.getTime());
    }

    @Test
    public void testmonth() throws Exception {
        List<Timestamp> monthStr = Test1.getMonthStr();
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
//        System.out.println(monthStr);
//        System.out.println(month);
        MonthCount monthCount = statisticsDao.getmonthcount2(month);
        System.out.println(monthCount);
    }


    public static List<Timestamp> getMonthStr() throws Exception {
        List<Timestamp> list = new ArrayList<Timestamp>();
        Long sj = System.currentTimeMillis();//时间戳
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy");
        String dateStr = dateformat.format(sj);
        for (int i=1;i<=12;i++){
//            List<Date> li = new ArrayList<Date>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            //Date date1=new Date(sdf.parse(dateStr+"-"+i).getTime());
            //list.add(date1);
            Timestamp timeStamp1=new Timestamp(sdf.parse(dateStr+"-"+i).getTime());
            list.add(timeStamp1);
//            String mydate = dateStr+"-"+i;
//            Date datetime = sdf.parse(mydate);//将你的日期转换为时间戳
//            Long time = datetime.getTime();
//            time = time/1000;
//            li.add(time);
//            list.add((Date) li);
        }
        return list;
    }

}
