/*
 *Author Name : Manikandan
 *Date : 24-01-2023
 */
package com.stackroute.Authentication.Automotive.vehicles.controller;

import com.stackroute.Authentication.Automotive.vehicles.exceptions.UserAlreadyExistsException;
import com.stackroute.Authentication.Automotive.vehicles.feignclient.SignUpData;
import com.stackroute.Authentication.Automotive.vehicles.model.User;
import com.stackroute.Authentication.Automotive.vehicles.service.JWTTokenGenerator;
import com.stackroute.Authentication.Automotive.vehicles.service.JWTTokenGeneratorImpl;
import com.stackroute.Authentication.Automotive.vehicles.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth-app")
public class UserController {

    @Autowired
    private UserService userService;

   @Autowired
   private JWTTokenGenerator jwtTokenGenerator;
   JWTTokenGenerator jwt = new JWTTokenGeneratorImpl();

    @PostMapping("/register-user")
    public ResponseEntity<?>registerUser(@RequestBody User user) throws UserAlreadyExistsException {
        try {
            user.setRole("ROLE_USER");
            user.setStatus("ACTIVE");
            return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
        } catch (UserAlreadyExistsException e) {
            throw new UserAlreadyExistsException();
        }

    }

    @PostMapping("/register-user-details")
    public ResponseEntity<?>registerUser1(@RequestBody SignUpData signUpData)throws UserAlreadyExistsException{
        try {

            return new ResponseEntity<>(userService.registerUser(signUpData),HttpStatus.OK);
        } catch (UserAlreadyExistsException e) {
            throw new UserAlreadyExistsException();
        }

    }

    @PostMapping("/login-check")
    public ResponseEntity<?>loginCheck(@RequestBody User user) {
        User result = userService.loginCheck(user.getEmailId(), user.getPassword());
        System.out.println(result);
        if (result != null && result.getStatus().equals("ACTIVE")) {
            result.setPassword("");
            return new ResponseEntity<>(jwtTokenGenerator.jwtGenerator(result), HttpStatus.OK);
//        return new ResponseEntity<>(result,HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Login Failed, Token Not Generated",HttpStatus.OK);
        }
    }
}
