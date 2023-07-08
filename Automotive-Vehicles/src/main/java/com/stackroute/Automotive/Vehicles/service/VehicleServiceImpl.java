/*
 *Author Name : Manikandan
 *Date : 25-01-2023
 */
package com.stackroute.Automotive.Vehicles.service;

import com.stackroute.Automotive.Vehicles.model.User;
import com.stackroute.Automotive.Vehicles.model.Vehicle;
import com.stackroute.Automotive.Vehicles.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {


    @Autowired

    private VehicleRepository vehicleRepository;


    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        System.out.println(vehicle);
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle getVehicles(String emailId) {
        return vehicleRepository.findById(emailId).get();
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }


    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public boolean deleteVehicle(String vehicleId) {
        vehicleRepository.deleteById(vehicleId);
        return true;
    }


}