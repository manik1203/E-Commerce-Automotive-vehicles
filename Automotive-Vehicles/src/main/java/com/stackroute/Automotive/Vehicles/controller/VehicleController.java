/*
 *Author Name : Manikandan
 *Date : 25-01-2023
 */
package com.stackroute.Automotive.Vehicles.controller;

import com.stackroute.Automotive.Vehicles.model.Vehicle;
import com.stackroute.Automotive.Vehicles.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
@RequestMapping("/vehicle-app")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;


    @PostMapping("/admin/add-new-vehicle")
    public ResponseEntity<?> addVehicle(@RequestBody Vehicle vehicle, HttpServletRequest request) {
        String current_user_emailId = (String) request.getAttribute("curr_user_emailId");
        System.out.println(current_user_emailId);
        return new ResponseEntity<>(vehicleService.addVehicle(vehicle), HttpStatus.OK);

    }


    @GetMapping("/get-vehicle")
    public ResponseEntity<?> getVehicles(HttpServletRequest request) {
        String current_user_emailId = (String) request.getAttribute("curr_user_emailId");
        System.out.println(current_user_emailId);
        return new ResponseEntity<>(vehicleService.getVehicles(current_user_emailId), HttpStatus.OK);
    }

    @GetMapping("/admin/get-all-vehicles")
    public ResponseEntity<?> getAllVehicles() {
        return new ResponseEntity<>(vehicleService.getAllVehicles(), HttpStatus.OK);
    }


    @PostMapping("/admin/update-vehicle")
    public ResponseEntity<?> updateVehicle(@RequestBody Vehicle vehicle) {
        return new ResponseEntity<>(vehicleService.updateVehicle(vehicle), HttpStatus.OK);
    }

    @DeleteMapping("/admin/delete-vehicle/{vehicleId}")
    public ResponseEntity<?> deleteVehicleById(@PathVariable String vehicleId) {
        return new ResponseEntity<>(vehicleService.deleteVehicle(vehicleId), HttpStatus.OK);
    }
}
