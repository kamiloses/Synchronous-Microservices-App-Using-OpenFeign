package com.kamiloses.bookingservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBookingNotFoundException(BookingNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
                "/booking/{id}",
                HttpStatus.NOT_FOUND.value(),
                "Booking not found",
                e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }



}
