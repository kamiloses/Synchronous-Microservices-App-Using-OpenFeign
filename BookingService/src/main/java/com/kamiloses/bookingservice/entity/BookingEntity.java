package com.kamiloses.bookingservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDate startDate;

    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    private Long userId;
    private Long carId;
}
//chce znależć encje którego userId wynosi np 75 i jak encja tyle wynosi ile zaznaczylem
//to wtedy sprawdza wszystkie carId którego które do tego należą
