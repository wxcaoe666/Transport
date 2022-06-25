package com.dao;

import com.model.Vehicle;
import com.model.Vehicleselect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IVehicleDao {
    List<Vehicle> getlist(Vehicleselect vehicleselect);

    Vehicle selectvehicle(String plateNumber);

    int addvehicle(Vehicle vehicle);

    Vehicle selectvehiclebyID(int ID);

    int deletevehicle(int ID);

    int updatevehicleuserid(@Param("VehicleID") int VehicleID,@Param("UserID")int UserID);

    int updatevehicle(Vehicle vehicle);
}
