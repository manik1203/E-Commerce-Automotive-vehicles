/*
 *Author Name : Manikandan
 *Date : 24-01-2023
 */
package com.stackroute.Automotive.Vehicles.controller;

import com.stackroute.Automotive.Vehicles.Exceptions.UserAlreadyExistsException;
import com.stackroute.Automotive.Vehicles.model.User;
import com.stackroute.Automotive.Vehicles.model.Vehicle;
import com.stackroute.Automotive.Vehicles.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/vehicle-app")
public class UserController {


    ResponseEntity responseEntity;

    @Autowired
    private UserService userService;


    @PostMapping("/add-user")
    public ResponseEntity<?> addUser(@RequestBody User user) throws UserAlreadyExistsException {
        try {
            user.setVehicles(new ArrayList<Vehicle>());
            return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
        } catch (UserAlreadyExistsException e) {
            throw new UserAlreadyExistsException();
        }

    }


    @GetMapping("/get-user-details")
    public ResponseEntity<?> getUser(HttpServletRequest request) {
        String current_user_emailId = (String) request.getAttribute("curr_user_emailId");
        System.out.println(current_user_emailId);
        return new ResponseEntity<>(userService.getUserDetails(current_user_emailId), HttpStatus.OK);
//        return new ResponseEntity<>(vehicleService.getUser(),HttpStatus.OK);
    }


    @PostMapping("/add-vehicle-to-user")
    public ResponseEntity<?> addVehicleToCurrentUser(@RequestBody Vehicle vehicle, HttpServletRequest request) {
        String current_user_emailId = (String) request.getAttribute("curr_user_emailId");
        System.out.println(current_user_emailId);
        responseEntity = new ResponseEntity<>(userService.addVehicleToCurrentUser(vehicle, current_user_emailId), HttpStatus.OK);

        return responseEntity;
    }

    /*
    DELETE
    http://localhost:9090/vehicle-app/admin/delete-from-cart/{vehicleId}
     */
    @DeleteMapping("/admin/delete-from-cart/{vehicleId}")
    public ResponseEntity<?> deleteVehicleFromCart(@PathVariable String vehicleId, HttpServletRequest request) {
        String current_user_emailId = (String) request.getAttribute("curr_user_emailId");
        System.out.println("currentUserEmailId = " + current_user_emailId);
        ResponseEntity responseEntity = new ResponseEntity(userService.deleteVehicleFromCart(current_user_emailId, vehicleId), HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/get-user-vehicle")
    public ResponseEntity<?> getuserVehicles(HttpServletRequest request) {
        String current_user_emailId = (String) request.getAttribute("curr_user_emailId");
        System.out.println(current_user_emailId);
        return new ResponseEntity<>(userService.getuserVehicleDetails(current_user_emailId).getVehicles(), HttpStatus.OK);
    }
}
