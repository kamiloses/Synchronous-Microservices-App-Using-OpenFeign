package com.kamiloses.bookingservice.dto;

import com.kamiloses.bookingservice.entity.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    private BookingStatus status;

}
