package com.stackroute.Automotive.Vehicles.repository;

import com.stackroute.Automotive.Vehicles.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User,String> {


}
