package com.service.Impl;

import com.dao.IVehicleDao;
import com.model.Vehicle;
import com.model.Vehicleselect;
import com.service.IVehicleService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class VehicleServiceimpl implements IVehicleService {

    @Resource
    private IVehicleDao vehicleDao;

    @Override
    public List<Vehicle> getlist(Vehicleselect vehicleselect) {
        return vehicleDao.getlist(vehicleselect);
    }

    @Override
    public Vehicle selectvehicle(String PlateNumber) {
        return vehicleDao.selectvehicle(PlateNumber);
    }

    @Override
    public int addvehicle(Vehicle vehicle) {
        return vehicleDao.addvehicle(vehicle);
    }

    @Override
    public Vehicle selectvehiclebyID(int ID) {
        return vehicleDao.selectvehiclebyID(ID);
    }

    @Override
    public int deletevehicle(int ID) {
        return vehicleDao.deletevehicle(ID);
    }

    @Override
    public int updatevehicleuserid(int VehicleID, int UserID) {
        return vehicleDao.updatevehicleuserid(VehicleID,UserID);
    }

    @Override
    public int updatevehicle(Vehicle vehicle) {
        return vehicleDao.updatevehicle(vehicle);
    }
}
