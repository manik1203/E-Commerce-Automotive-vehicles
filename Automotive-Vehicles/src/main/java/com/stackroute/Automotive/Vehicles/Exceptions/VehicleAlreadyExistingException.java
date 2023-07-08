/*
 *Author Name : Manikandan
 *Date : 01-02-2023
 */
package com.stackroute.Automotive.Vehicles.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT ,reason = "Vehicle Already Exists")

public class VehicleAlreadyExistingException extends Exception{
}
