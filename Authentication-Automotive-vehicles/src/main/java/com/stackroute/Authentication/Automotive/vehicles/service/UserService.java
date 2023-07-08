package com.stackroute.Authentication.Automotive.vehicles.service;

import com.stackroute.Authentication.Automotive.vehicles.exceptions.UserAlreadyExistsException;
import com.stackroute.Authentication.Automotive.vehicles.feignclient.SignUpData;
import com.stackroute.Authentication.Automotive.vehicles.model.User;

public interface UserService {

public abstract User addUser(User user)throws UserAlreadyExistsException;

public abstract User registerUser(SignUpData signUpData)throws UserAlreadyExistsException;

public abstract User loginCheck(String emailid,String password);
}
