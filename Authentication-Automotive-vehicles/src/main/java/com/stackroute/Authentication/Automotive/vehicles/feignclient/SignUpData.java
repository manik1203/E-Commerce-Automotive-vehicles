/*
 *Author Name : Manikandan
 *Date : 25-01-2023
 */
package com.stackroute.Authentication.Automotive.vehicles.feignclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignUpData {

    private String emailId, password, name, address;
}
