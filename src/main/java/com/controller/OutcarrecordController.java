package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.model.*;
import com.service.IOutcarrecordService;
import com.service.IUserService;
import com.service.IVehicleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/outcarrecord")
public class OutcarrecordController {

    @Resource
    private IOutcarrecordService outcarrecordService;

    @Resource
    private IVehicleService vehicleService;

    @Resource
    private IUserService userService;

    //获取所有未删除的出车申请
    @RequestMapping(value = "/getalllist", method = RequestMethod.GET)
    @ResponseBody
    public List<Outcarrecordlist> getalllist() {
//        List<Vehicle> getlist = vehicleService.getlist();
//        if (getlist.size()>0){
//            for (int i = 0; i < getlist.size(); i++) {
//                Timestamp purchasingDate = getlist.get(i).getPurchasingDate();
//                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                String format = simpleDateFormat.format(purchasingDate);
//                getlist.set(i).setPurchasingDate(format);
//            }
//        }
        return outcarrecordService.getalllist();
    }

    //获取未删除的未允许未撤销的出车申请
    @RequestMapping(value = "/getIsAllowlist", method = RequestMethod.GET)
    @ResponseBody
    public List<Outcarrecordlist> getIsAllowlist() {
        return outcarrecordService.getIsAllowlist();

    }

    //未删除已撤销的出车申请
    @RequestMapping(value = "/getIsRevocation", method = RequestMethod.GET)
    @ResponseBody
    public List<Outcarrecordlist> getIsRevocation() {
        return outcarrecordService.getIsRevocation();

    }

    //未删除已撤销的出车申请分页
    @RequestMapping(value = "/getIsRevocationlist", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Outcarrecordlist> getIsRevocationlist(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Outcarrecordlist> list = outcarrecordService.getIsRevocation();
        PageInfo<Outcarrecordlist> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    //根据ID获取出车申请
    @RequestMapping(value = "/selectoutcarrecordbyID", method = RequestMethod.GET)
    @ResponseBody
    public Outcarrecord selectoutcarrecordbyID(int ID) {
        return outcarrecordService.selectoutcarrecordbyID(ID);
    }

    //获取所有未删除的出车申请分页
    @RequestMapping(value = "/getalloutcarrecordlist", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Outcarrecordlist> getalloutcarrecordlist(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Outcarrecordlist> list = outcarrecordService.getalllist();
        PageInfo<Outcarrecordlist> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    //获取未删除的未允许未撤销的出车申请分页
    @RequestMapping(value = "/getIsAllowoutcarrecordlist", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Outcarrecordlist> getIsAllowoutcarrecordlist(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Outcarrecordlist> list = outcarrecordService.getIsAllowlist();
        PageInfo<Outcarrecordlist> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 修改出车申请
     * @param outcarrecord
     * @return
     */
    @RequestMapping(value = "/updateoutcarrecord", method = RequestMethod.POST)
    @ResponseBody
    public int updateoutcarrecord(@RequestBody Outcarrecord outcarrecord) {

        int userID = outcarrecord.getUserID();
        int isRevocation = outcarrecord.getIsRevocation();
        int vehicleID = outcarrecord.getVehicleID();
        //查询车辆是否存在
        Vehicle vehicle = vehicleService.selectvehiclebyID(vehicleID);
        //查询车辆是否存在出车任务
        Outcarrecord outcarrecord2 = outcarrecordService.selectoutcarrecordbyvehicleID(vehicleID);
        //改变撤销状态
        if(isRevocation==1){
            outcarrecord.setIsRevocation(0);
        }

        if (vehicle == null) {
            return 2;//该车辆不存在
        } else if (outcarrecord2 == null) {
            return outcarrecordService.updateoutcarrecord(outcarrecord);
        } else if (userID != outcarrecord2.getUserID()) {
            return 3;//已有人使用该车辆
        } else {
            return outcarrecordService.updateoutcarrecord(outcarrecord);
        }
    }

    /**
     * 新增出车申请
     * @param outcarrecord
     * @return
     */
    @RequestMapping(value = "/addoutcarrecord", method = RequestMethod.POST)
    @ResponseBody
    public int addoutcarrecord(@RequestBody Outcarrecord outcarrecord) {
        int userID = outcarrecord.getUserID();
        int vehicleID = outcarrecord.getVehicleID();
        //查询车辆是否存在
        Vehicle vehicle = vehicleService.selectvehiclebyID(vehicleID);
        //查询用户是否存在
        User user = userService.selectuserbyID(userID);
        //查询用户是否存在出车任务
        List<Outcarrecord> outcarrecord1 = outcarrecordService.selectstatebyUserID(userID);
        //查询车辆是否存在出车任务
        List<Outcarrecord> outcarrecord2 = outcarrecordService.selectstatebyVehiclevID(vehicleID);
        if (user == null) {
            return 6;//用户不存在
        } else if (vehicle == null) {
            return 7;//车辆不存在
        } else if (outcarrecord1.size() != 0 && outcarrecord2.size() == 0) {
            return 3;//用户已有出车任务
        } else if (outcarrecord1.size() == 0 && outcarrecord2.size() != 0) {
            return 4;//车辆已有出车任务
        } else if (outcarrecord1.size() != 0 && outcarrecord2.size() != 0) {
            return 5;//用户与车辆均已有出车任务
        } else if (outcarrecord1.size() == 0 && outcarrecord2.size() == 0) {
            Timestamp d = new Timestamp(System.currentTimeMillis());
            outcarrecord.setCreateDate(d);
            outcarrecord.setState(0);
            outcarrecord.setDeleteFlag(0);
            outcarrecord.setIsAllow(0);
            return outcarrecordService.addoutcarrecord(outcarrecord);
        } else {
            return 0;//其他错误
        }
    }

    //根据ID删除出车申请
    @RequestMapping(value = "/deleteoutcarrecord", method = RequestMethod.GET)
    @ResponseBody
    public int deleteoutcarrecord(int ID) {
        Outcarrecord outcarrecord = outcarrecordService.selectoutcarrecordbyID(ID);
        int isAllow = outcarrecord.getIsAllow();
        if (isAllow == 1) {
            return 2;//该申请已被允许,请先撤销申请
        } else {
            return outcarrecordService.deleteoutcarrecord(ID);
        }
    }

    //根据ID撤销出车申请
    @RequestMapping(value = "/revocationoutcarrecord", method = RequestMethod.GET)
    @ResponseBody
    public int revocationoutcarrecord(int ID) {
        Outcarrecord outcarrecord = outcarrecordService.selectoutcarrecordbyID(ID);
            return outcarrecordService.revocationoutcarrecord(ID);
    }

    //根据ID更改出车申请的状态
    @RequestMapping(value = "/outcarrecordIsAllow", method = RequestMethod.GET)
    @ResponseBody
    public int outcarrecordIsAllow(int ID, int IsAllow, int VehicleID, int UserID) {
        int updatevehicleuserid = vehicleService.updatevehicleuserid(VehicleID, UserID);
        if (updatevehicleuserid == 1) {
            return outcarrecordService.outcarrecordIsAllow(ID, IsAllow);
        } else {
            return 0;
        }
    }

    //根据ID运输的状态
    @RequestMapping(value = "/outcarrecordState", method = RequestMethod.GET)
    @ResponseBody
    public int outcarrecordState(int ID, int State, int VehicleID) {
        if (State == 2) {
            int updatevehicleuserid = vehicleService.updatevehicleuserid(VehicleID, 0);
            if (updatevehicleuserid == 1) {
                return outcarrecordService.outcarrecordState(ID, State);
            } else {
                return 0;
            }
        } else {
            return outcarrecordService.outcarrecordState(ID, State);
        }
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //个人所有出车记录
    @RequestMapping(value = "/getalllistbyid", method = RequestMethod.GET)
    @ResponseBody
    public List<Outcarrecordlist> getalllistbyid(int UserID) {
        return outcarrecordService.getalllistbyid(UserID);
    }

    //个人所有出车记录分页
    @RequestMapping(value = "/getalloutcarrecordlistbyid", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Outcarrecordlist> getalloutcarrecordlistbyid(int pageNum, int pageSize, int UserID) {
        PageHelper.startPage(pageNum, pageSize);
        List<Outcarrecordlist> list = outcarrecordService.getalllistbyid(UserID);
        PageInfo<Outcarrecordlist> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    //个人所有是否允许出车记录
    @RequestMapping(value = "/getIsAllowbyid", method = RequestMethod.GET)
    @ResponseBody
    public List<Outcarrecordlist> getIsAllowbyid(int UserID, int IsAllow) {
        return outcarrecordService.getIsAllowbyid(UserID, IsAllow);
    }

    //个人所有是否允许出车记录分页
    @RequestMapping(value = "/getIsAllowbyidmaintainlistbyid", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Outcarrecordlist> getIsAllowbyidmaintainlistbyid(int pageNum, int pageSize, int UserID, int IsAllow) {
        PageHelper.startPage(pageNum, pageSize);
        List<Outcarrecordlist> list = outcarrecordService.getIsAllowbyid(UserID, IsAllow);
        PageInfo<Outcarrecordlist> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    //个人所有已撤销出车记录
    @RequestMapping(value = "/getIsRevocationbyid", method = RequestMethod.GET)
    @ResponseBody
    public List<Outcarrecordlist> getIsRevocationbyid(int UserID) {
        return outcarrecordService.getIsRevocationbyid(UserID);
    }

    //个人所有已撤销维修记录分页
    @RequestMapping(value = "/getIsRevocationlistbyid", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Outcarrecordlist> getIsRevocationlistbyid(int pageNum, int pageSize, int UserID) {
        PageHelper.startPage(pageNum, pageSize);
        List<Outcarrecordlist> list = outcarrecordService.getIsRevocationbyid(UserID);
        PageInfo<Outcarrecordlist> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    //个人所有已完成出车记录
    @RequestMapping(value = "/getstatebyid", method = RequestMethod.GET)
    @ResponseBody
    public List<Outcarrecordlist> getstatebyid(int UserID) {
        return outcarrecordService.getstatebyid(UserID);
    }

    //个人所有已完成出车记录分页
    @RequestMapping(value = "/getstatemaintainlistbyid", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Outcarrecordlist> getstatemaintainlistbyid(int pageNum, int pageSize, int UserID) {
        PageHelper.startPage(pageNum, pageSize);
        List<Outcarrecordlist> list = outcarrecordService.getstatebyid(UserID);
        PageInfo<Outcarrecordlist> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
