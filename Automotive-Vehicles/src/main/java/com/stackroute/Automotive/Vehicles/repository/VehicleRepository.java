package com.stackroute.Automotive.Vehicles.repository;

import com.stackroute.Automotive.Vehicles.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepository extends MongoRepository<Vehicle,String> {


}
