/*
 *Author Name : Manikandan
 *Date : 24-01-2023
 */
package com.stackroute.Automotive.Vehicles.service;

import com.stackroute.Automotive.Vehicles.Exceptions.UserAlreadyExistsException;
import com.stackroute.Automotive.Vehicles.model.User;
import com.stackroute.Automotive.Vehicles.model.Vehicle;
import com.stackroute.Automotive.Vehicles.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) throws UserAlreadyExistsException {
        if (userRepository.findById(user.getEmailId()).isEmpty()) {
            return userRepository.insert(user);
        } else {
            throw new UserAlreadyExistsException();
        }
    }

    @Override
    public User getUserDetails(String emailId) {
        return userRepository.findById(emailId).get();
    }

    @Override
    public User addVehicleToCurrentUser(Vehicle vehicle, String emailId)  {
      User user = userRepository.findById(emailId).get();
      user.getVehicles().add(vehicle);
      return userRepository.save(user);
    }


    @Override
    public User deleteVehicleFromCart(String emailId, String vehicleId) {
        User user = userRepository.findById(emailId).orElseThrow();
        System.out.println(user);
        List<Vehicle> vehicles = user.getVehicles();
        System.out.println(vehicles);
        System.out.println(vehicleId);
        vehicles.remove(vehicles.stream().filter(v -> v.getVehicleId().equals(vehicleId)).findFirst().get());
        user.setVehicles(vehicles);
        return userRepository.save(user);
    }

    @Override
    public User getuserVehicleDetails(String emailId) {
        return userRepository.findById(emailId).get();
    }


}
