package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.model.Vehicle;
import com.model.Vehicleselect;
import com.service.IVehicleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Resource
    private IVehicleService vehicleService;

    @RequestMapping(value = "/addvehicle", method = RequestMethod.POST)
    @ResponseBody
    public int addvehicle(@RequestBody Vehicle vehicle) {
        String plateNumber = vehicle.getPlateNumber();
        Vehicle vehicle1 = vehicleService.selectvehicle(plateNumber);
        if (vehicle1 == null) {
            vehicle.setDeleteFlag(0);
            return vehicleService.addvehicle(vehicle);
        } else {
            return 0;
        }
    }


    @RequestMapping(value = "/updatevehicle", method = RequestMethod.POST)
    @ResponseBody
    public int updatevehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.updatevehicle(vehicle);
    }


    @RequestMapping(value = "/getlist", method = RequestMethod.POST)
    @ResponseBody
    public List<Vehicle> getlist(Vehicleselect vehicleselect) {
        return vehicleService.getlist(vehicleselect);
    }

    @RequestMapping(value = "/getvehiclelist", method = RequestMethod.POST)
    @ResponseBody
    public PageInfo<Vehicle> getvehiclelist(@RequestBody Vehicleselect vehicleselect) {
        int pageNum = vehicleselect.getPageNum();
        int pageSize = vehicleselect.getPageSize();
        String selectname = vehicleselect.getSelectname();
        String selectbrand = vehicleselect.getSelectbrand();
        String selectnum = vehicleselect.getSelectnum();
        if (selectname != null && selectname != "") {
            String str = "%" + selectname + "%";
            vehicleselect.setSelectname(str);
        }
        if (selectbrand != null && selectbrand != "") {
            String str1 = "%" + selectbrand + "%";
            vehicleselect.setSelectbrand(str1);
        }
        if (selectnum != null && selectnum != "") {
            String str2 = "%" + selectnum + "%";
            vehicleselect.setSelectnum(str2);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Vehicle> list = vehicleService.getlist(vehicleselect);
        PageInfo<Vehicle> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @RequestMapping(value = "/selectvehiclebyID", method = RequestMethod.GET)
    @ResponseBody
    public Vehicle selectvehiclebyID(int ID) {
        return vehicleService.selectvehiclebyID(ID);
    }

    @RequestMapping(value = "/deletevehicle", method = RequestMethod.GET)
    @ResponseBody
    public int deletevehicle(int ID) {
        return vehicleService.deletevehicle(ID);
    }
}
