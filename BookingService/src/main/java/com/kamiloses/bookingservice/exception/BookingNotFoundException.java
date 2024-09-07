package com.kamiloses.bookingservice.exception;

public class BookingNotFoundException extends RuntimeException {

    public BookingNotFoundException(String message) {
        super(message);
    }
}
