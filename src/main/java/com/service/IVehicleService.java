package com.service;

import com.model.Vehicle;
import com.model.Vehicleselect;

import java.util.List;

public interface IVehicleService {
    List<Vehicle> getlist(Vehicleselect vehicleselect);

    Vehicle selectvehicle(String PlateNumber);

    int addvehicle(Vehicle vehicle);

    Vehicle selectvehiclebyID(int ID);

    int deletevehicle(int ID);

    int updatevehicleuserid(int VehicleID, int UserID);

    int updatevehicle(Vehicle vehicle);
}
