package com.stackroute.Automotive.Vehicles.service;

import com.stackroute.Automotive.Vehicles.Exceptions.UserAlreadyExistsException;
import com.stackroute.Automotive.Vehicles.Exceptions.UserNotFoundException;
import com.stackroute.Automotive.Vehicles.Exceptions.VehicleAlreadyExistingException;
import com.stackroute.Automotive.Vehicles.model.User;
import com.stackroute.Automotive.Vehicles.model.Vehicle;

public interface UserService {


    public abstract User addUser(User user) throws UserAlreadyExistsException;

//    public abstract List<User> getUser();
    public abstract User getUserDetails(String emailId);

    public abstract User addVehicleToCurrentUser(Vehicle vehicle,String emailId);

    public abstract User deleteVehicleFromCart(String emailId,String vehicleId);

    public abstract  User getuserVehicleDetails(String emailId);
}
