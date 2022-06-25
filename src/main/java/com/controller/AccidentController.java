package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.model.*;
import com.service.IAccidentService;
import com.service.IUserService;
import com.service.IVehicleService;
import com.service.IViolationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/accident")
public class AccidentController {

    @Resource
    private IAccidentService accidentService;

    @Resource
    private IVehicleService vehicleService;

    @Resource
    private IUserService userService;

    //获取所有未删除的事故记录
    @RequestMapping(value = "/getalllist", method = RequestMethod.GET)
    @ResponseBody
    public List<Accidentlist> getalllist() {
        return accidentService.getalllist();
    }


    //获取所有未删除的事故记录分页
    @RequestMapping(value = "/getallaccidentlist", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Accidentlist> getallaccidentlist(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Accidentlist> list = accidentService.getalllist();
        PageInfo<Accidentlist> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    //添加事故记录
    @RequestMapping(value = "/addaccident", method = RequestMethod.POST)
    @ResponseBody
    public int addaccident(@RequestBody Accident accident) {
        int userID = accident.getUserID();
        int vehicleID = accident.getVehicleID();
        //查询车辆是否存在
        Vehicle vehicle = vehicleService.selectvehiclebyID(vehicleID);
        //查询用户是否存在
        User user = userService.selectuserbyID(userID);
        if (user == null) {
            return 2;//用户不存在
        } else if (vehicle == null) {
            return 3;//车辆不存在
        } else if (user != null && vehicle != null) {
            Timestamp d = new Timestamp(System.currentTimeMillis());
            accident.setCreateDate(d);
            accident.setDeleteFlag(0);
            return accidentService.addaccident(accident);
        } else {
            return 0;//其他错误
        }
    }

    //根据id删除事故
    @RequestMapping(value = "/deleteaccident", method = RequestMethod.GET)
    @ResponseBody
    public int deleteviolation(int ID) {
        return accidentService.deleteaccident(ID);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //个人所有事故记录
    @RequestMapping(value = "/getalllistbyid",method = RequestMethod.GET)
    @ResponseBody
    public List<Accidentlist> getalllistbyid(int UserID){
        return accidentService.getalllistbyid(UserID);
    }

    //个人所有事故记录分页
    @RequestMapping(value = "/getallaccidentlistbyid",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Accidentlist> getallaccidentlistbyid(int pageNum, int pageSize,int UserID){
        PageHelper.startPage(pageNum,pageSize);
        List<Accidentlist> list = accidentService.getalllistbyid(UserID);
        PageInfo<Accidentlist> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 根据ID查询事故记录
     * @param ID
     * @return
     */
    @RequestMapping(value = "/selectaccidentbyID", method = RequestMethod.GET)
    @ResponseBody
    public Accident selectaccidentbyID(int ID) {
        return accidentService.selectaccidentbyID(ID);
    }

    /**
     * 修改事故记录
     * @param accident
     * @return
     */
    @RequestMapping(value = "/updateaccident", method = RequestMethod.POST)
    @ResponseBody
    public int updateaccident(@RequestBody Accident accident) {
        int vehicleID = accident.getVehicleID();
        //查询车辆是否存在
        Vehicle vehicle = vehicleService.selectvehiclebyID(vehicleID);
        if (vehicle == null) {
            return 2;//该车辆不存在
        } else {
            return accidentService.updateaccident(accident);
        }
    }

}
