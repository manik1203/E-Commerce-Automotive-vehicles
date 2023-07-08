/*
 *Author Name : Manikandan
 *Date : 24-01-2023
 */
package com.stackroute.Automotive.Vehicles.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class Vehicle {
    @Id
    private String vehicleId;
    private String vehicleName;
    private String price;
}
