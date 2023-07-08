package com.stackroute.Automotive.Vehicles.service;

import com.stackroute.Automotive.Vehicles.model.Vehicle;


import java.util.List;

public interface VehicleService {

    public abstract Vehicle addVehicle(Vehicle vehicle);

    public abstract Vehicle getVehicles(String emailId);

    public abstract List<Vehicle> getAllVehicles();


    public abstract Vehicle updateVehicle(Vehicle vehicle);

    public abstract boolean deleteVehicle(String vehicleId);

}
