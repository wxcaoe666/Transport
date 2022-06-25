package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.model.*;
import com.service.IMaintainService;
import com.service.IUserService;
import com.service.IVehicleService;
import com.service.IViolationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/violation")
public class ViolationController {

    @Resource
    private IViolationService violationService;

    @Resource
    private IVehicleService vehicleService;

    @Resource
    private IUserService userService;

    //获取所有未删除的违章记录
    @RequestMapping(value = "/getalllist",method = RequestMethod.GET)
    @ResponseBody
    public List<Violationlist> getalllist(){
            return violationService.getalllist();
    }

    //获取所有未删除的违章记录分页
    @RequestMapping(value = "/getallviolationlist",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Violationlist> getallviolationlist(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Violationlist> list = violationService.getalllist();
        PageInfo<Violationlist> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @RequestMapping(value = "/addviolation",method = RequestMethod.POST)
    @ResponseBody
    public int addviolation(@RequestBody Violation violation){
        int userID = violation.getUserID();
        int vehicleID = violation.getVehicleID();
        //查询车辆是否存在
        Vehicle vehicle = vehicleService.selectvehiclebyID(vehicleID);
        //查询用户是否存在
        User user = userService.selectuserbyID(userID);
        if(user==null){
            return 2;//用户不存在
        } else if (vehicle==null) {
            return 3;//车辆不存在
        } else if (user != null && vehicle != null) {
            Timestamp d = new Timestamp(System.currentTimeMillis());
            violation.setCreateDate(d);
            violation.setDeleteFlag(0);
            return violationService.addviolation(violation);
        } else {
            return 0;//其他错误
        }
    }

    @RequestMapping(value = "/deleteviolation",method=RequestMethod.GET)
    @ResponseBody
    public int deleteviolation(int ID){
        return violationService.deleteviolation(ID);
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //个人所有违章记录
    @RequestMapping(value = "/getalllistbyid",method = RequestMethod.GET)
    @ResponseBody
    public List<Violationlist> getalllistbyid(int UserID){
        return violationService.getalllistbyid(UserID);
    }

    //个人所有违章记录分页
    @RequestMapping(value = "/getallviolationlistbyid",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Violationlist> getallviolationlistbyid(int pageNum, int pageSize,int UserID){
        PageHelper.startPage(pageNum,pageSize);
        List<Violationlist> list = violationService.getalllistbyid(UserID);
        PageInfo<Violationlist> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }


    /**
     * 根据ID查询违章记录
     * @param ID
     * @return
     */
    @RequestMapping(value = "/selectviolationbyID", method = RequestMethod.GET)
    @ResponseBody
    public Violation selectviolationbyID(int ID) {
        return violationService.selectviolationbyID(ID);
    }

    /**
     * 修改出车申请
     *
     * @param violation
     * @return
     */
    @RequestMapping(value = "/updateviolation", method = RequestMethod.POST)
    @ResponseBody
    public int updateviolation(@RequestBody Violation violation) {
        int vehicleID = violation.getVehicleID();
        //查询车辆是否存在
        Vehicle vehicle = vehicleService.selectvehiclebyID(vehicleID);
        if (vehicle == null) {
            return 2;//该车辆不存在
        } else {
            return violationService.updateviolation(violation);
        }
    }

}
