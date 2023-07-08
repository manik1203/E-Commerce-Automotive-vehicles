/*
 *Author Name : Manikandan
 *Date : 24-01-2023
 */
package com.stackroute.Automotive.Vehicles.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT ,reason = "User Already Exists")
public class UserAlreadyExistsException extends Exception{
}
