package com.kamiloses.bookingservice.dto;

import com.kamiloses.bookingservice.enums.CarStatus;
import com.kamiloses.bookingservice.enums.FuelType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {


    private Long id;
    private String brand;

    private String model;

    private Year year;

    private CarStatus carStatus;

    private Double dailyRate;

    private FuelType fuelType;

    private Integer mileage;



}
