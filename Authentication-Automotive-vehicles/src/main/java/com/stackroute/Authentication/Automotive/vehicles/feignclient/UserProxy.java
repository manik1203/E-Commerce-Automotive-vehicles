package com.stackroute.Authentication.Automotive.vehicles.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//
@FeignClient(name = "vehicle-app" ,url = "localhost:9090")
public interface UserProxy {


    @PostMapping("/vehicle-app/add-user")
    public abstract ResponseEntity<?>sendUserDtoToVehicleApp(@RequestBody UserDTO userDTO);
}
