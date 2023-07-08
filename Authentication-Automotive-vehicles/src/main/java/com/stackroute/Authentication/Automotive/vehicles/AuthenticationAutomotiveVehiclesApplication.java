package com.stackroute.Authentication.Automotive.vehicles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AuthenticationAutomotiveVehiclesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationAutomotiveVehiclesApplication.class, args);
	}

}
