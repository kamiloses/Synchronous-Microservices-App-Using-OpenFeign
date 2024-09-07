package com.kamiloses.carinventoryservice.entity;

import com.kamiloses.carinventoryservice.enums.CarStatus;
import com.kamiloses.carinventoryservice.enums.FuelType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private String model;

    private Year year;
    @Enumerated(EnumType.STRING)
    private CarStatus carStatus;

    private Double dailyRate;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

     private Integer mileage;



}
