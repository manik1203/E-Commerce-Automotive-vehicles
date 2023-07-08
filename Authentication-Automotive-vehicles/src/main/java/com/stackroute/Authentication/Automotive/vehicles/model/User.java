/*
 *Author Name : Manikandan
 *Date : 24-01-2023
 */
package com.stackroute.Authentication.Automotive.vehicles.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    private String emailId;
    private String password,role,status;
    }

