package com.kamiloses.bookingservice.dto;

import com.kamiloses.bookingservice.entity.BookingStatus;
import com.kamiloses.bookingservice.entity.CarStatus;
import com.kamiloses.bookingservice.entity.FuelType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Year;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRentalDto {

    private LocalDate startDate;

    private LocalDate endDate;

    private BookingStatus status;

    private Long userId;
    private Long carId;

    private String brand;

    private String model;

    private Year year;

    private CarStatus carStatus;

    private Double dailyRate;

    private FuelType fuelType;

    private Integer mileage;
}
