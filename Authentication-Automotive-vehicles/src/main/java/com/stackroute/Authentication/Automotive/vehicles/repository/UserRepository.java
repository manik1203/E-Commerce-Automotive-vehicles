package com.stackroute.Authentication.Automotive.vehicles.repository;

import com.stackroute.Authentication.Automotive.vehicles.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {


    public abstract User findByEmailIdAndPassword(String emailId, String password);
}
