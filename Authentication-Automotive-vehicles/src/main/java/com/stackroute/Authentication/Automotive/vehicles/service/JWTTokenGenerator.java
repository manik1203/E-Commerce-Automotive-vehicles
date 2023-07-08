package com.stackroute.Authentication.Automotive.vehicles.service;

import com.stackroute.Authentication.Automotive.vehicles.model.User;

import java.util.Map;

public interface JWTTokenGenerator {

    public abstract Map<String,String> jwtGenerator(User user);
}
