/*
 *Author Name : Manikandan
 *Date : 24-01-2023
 */
package com.stackroute.Authentication.Automotive.vehicles.service;

import com.stackroute.Authentication.Automotive.vehicles.exceptions.UserAlreadyExistsException;
import com.stackroute.Authentication.Automotive.vehicles.feignclient.SignUpData;
import com.stackroute.Authentication.Automotive.vehicles.feignclient.UserDTO;
import com.stackroute.Authentication.Automotive.vehicles.feignclient.UserProxy;
import com.stackroute.Authentication.Automotive.vehicles.model.User;
import com.stackroute.Authentication.Automotive.vehicles.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProxy userProxy;

    @Override
    public User addUser(User user) throws UserAlreadyExistsException {
        if (userRepository.findById(user.getEmailId()).isEmpty()) {
            return userRepository.save(user);
        } else {
            throw new UserAlreadyExistsException();
        }
    }

    @Override
    public User registerUser(SignUpData signUpData) throws UserAlreadyExistsException {
        UserDTO userDTO = new UserDTO(signUpData.getEmailId(),signUpData.getName(),signUpData.getAddress());
        ResponseEntity re = userProxy.sendUserDtoToVehicleApp(userDTO);
        System.out.println(re);
        User user = new User(signUpData.getEmailId(), signUpData.getPassword(), "ROLE_USER","ACTIVE");
        return userRepository.save(user);
    }

    @Override
    public User loginCheck(String emailid, String password) {
        return userRepository.findByEmailIdAndPassword(emailid, password);
    }
}
