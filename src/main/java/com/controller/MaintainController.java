package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.model.*;
import com.service.IMaintainService;
import com.service.IUserService;
import com.service.IVehicleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/maintain")
public class MaintainController {

    @Resource
    private IMaintainService maintainService;

    @Resource
    private IVehicleService vehicleService;

    @Resource
    private IUserService userService;

    //根据ID删除维修申请
    @RequestMapping(value = "/deletemaintain",method = RequestMethod.GET)
    @ResponseBody
    public int deletemaintain(int ID){
        Maintain maintain = maintainService.selectmaintainbyID(ID);
        int isAllow = maintain.getIsAllow();
        if (isAllow==1){
            return 2;//该申请已被允许,
        }else {
        return maintainService.deletemaintain(ID);
        }
    }

    //获取所有未删除的出车申请
    @RequestMapping(value = "/getalllist",method = RequestMethod.GET)
    @ResponseBody
    public List<Maintainlist> getalllist(){
            return maintainService.getalllist();
    }

    //获取未删除的未允许未撤销的出车申请
    @RequestMapping(value = "/getIsAllowlist",method = RequestMethod.GET)
    @ResponseBody
    public List<Maintainlist> getIsAllowlist(){
        return maintainService.getIsAllowlist();

    }

    //获取未删除已撤销的出车申请
    @RequestMapping(value = "/getIsRevocationlist",method = RequestMethod.GET)
    @ResponseBody
    public List<Maintainlist> getIsRevocationlist(){
        return maintainService.getIsRevocationlist();
    }

    //获取未删除已撤销的出车申请分页
    @RequestMapping(value = "/getIsRevocationmaintainlist",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Maintainlist> getIsRevocationmaintainlist(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Maintainlist> list = maintainService.getIsRevocationlist();
        PageInfo<Maintainlist> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    //个人所有维修记录
    @RequestMapping(value = "/getalllistbyid",method = RequestMethod.GET)
    @ResponseBody
    public List<Maintainlist> getalllistbyid(int UserID){
        return maintainService.getalllistbyid(UserID);
    }

    //个人所有维修记录分页
    @RequestMapping(value = "/getallmaintainlistbyid",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Maintainlist> getallmaintainlistbyid(int pageNum, int pageSize,int UserID){
        PageHelper.startPage(pageNum,pageSize);
        List<Maintainlist> list = maintainService.getalllistbyid(UserID);
        PageInfo<Maintainlist> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    //个人所有是否允许维修记录
    @RequestMapping(value = "/getIsAllowbyid",method = RequestMethod.GET)
    @ResponseBody
    public List<Maintainlist> getIsAllowbyid(int UserID,int IsAllow){
        return maintainService.getIsAllowbyid(UserID,IsAllow);
    }

    //个人所有是否允许维修记录分页
    @RequestMapping(value = "/getIsAllowbyidmaintainlistbyid",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Maintainlist> getIsAllowbyidmaintainlistbyid(int pageNum, int pageSize,int UserID,int IsAllow){
        PageHelper.startPage(pageNum,pageSize);
        List<Maintainlist> list = maintainService.getIsAllowbyid(UserID,IsAllow);
        PageInfo<Maintainlist> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    //个人所有已撤销维修记录
    @RequestMapping(value = "/getIsRevocationbyid",method = RequestMethod.GET)
    @ResponseBody
    public List<Maintainlist> getIsRevocationbyid(int UserID){
        return maintainService.getIsRevocationbyid(UserID);
    }

    //个人所有已撤销维修记录分页
    @RequestMapping(value = "/getIsRevocationbyidmaintainlistbyid",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Maintainlist> getIsRevocationbyidmaintainlistbyid(int pageNum, int pageSize,int UserID){
        PageHelper.startPage(pageNum,pageSize);
        List<Maintainlist> list = maintainService.getIsRevocationbyid(UserID);
        PageInfo<Maintainlist> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    //获取所有未删除的出车申请分页
    @RequestMapping(value = "/getallmaintainlist",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Maintainlist> getallmaintainlist(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Maintainlist> list = maintainService.getalllist();
        PageInfo<Maintainlist> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    //获取未删除的未允许未撤销的出车申请分页
    @RequestMapping(value = "/getIsAllowmaintainlist",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Maintainlist> getIsAllowmaintainlist(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Maintainlist> list = maintainService.getIsAllowlist();
        PageInfo<Maintainlist> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @RequestMapping(value = "/addmaintain",method = RequestMethod.POST)
    @ResponseBody
    public int addmaintain(@RequestBody Maintain maintain){
        int userID = maintain.getUserID();
        int vehicleID = maintain.getVehicleID();
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
            maintain.setMaintainDate(d);
            maintain.setState(0);
            maintain.setDeleteFlag(0);
            maintain.setIsAllow(0);
            return maintainService.addmaintain(maintain);
        } else {
            return 0;//其他错误
        }
    }

    //根据ID撤销维修申请
    @RequestMapping(value = "/revocationmaintain",method = RequestMethod.GET)
    @ResponseBody
    public int revocationmaintain(int ID){
            return maintainService.revocationmaintain(ID);
    }

    //根据ID更改维修申请的状态
    @RequestMapping(value = "/maintainIsAllow",method = RequestMethod.GET)
    @ResponseBody
    public int maintainIsAllow(int ID,int IsAllow){
            return maintainService.maintainIsAllow(ID,IsAllow);
    }

    /**
     * 修改出车申请
     * @param maintain
     * @return
     */
    @RequestMapping(value = "/updatemaintain", method = RequestMethod.POST)
    @ResponseBody
    public int updatemaintain(@RequestBody Maintain maintain) {
        int vehicleID = maintain.getVehicleID();
        int isRevocation = maintain.getIsRevocation();
        //查询车辆是否存在
        Vehicle vehicle = vehicleService.selectvehiclebyID(vehicleID);
        //改变撤销状态
        if(isRevocation==1){
            maintain.setIsRevocation(0);
        }

        if (vehicle == null) {
            return 2;//该车辆不存在
        } else {
            return maintainService.updatemaintain(maintain);
        }
    }

    /**
     * 根据ID查询维修记录
     * @param ID
     * @return
     */
    @RequestMapping(value = "/selectmaintainbyID", method = RequestMethod.GET)
    @ResponseBody
    public Maintain selectmaintainbyID(int ID) {
        return maintainService.selectmaintainbyID(ID);
    }

}
