package com.kamiloses.bookingservice.controller;

import com.kamiloses.bookingservice.dto.BookingDto;
import com.kamiloses.bookingservice.dto.CarDto;
import com.kamiloses.bookingservice.feign.FeignCarService;
import com.kamiloses.bookingservice.feign.FeignUserService;
import com.kamiloses.bookingservice.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;
    private final FeignCarService feignCarService;
    private final FeignUserService feignUserService;

    public BookingController(BookingService bookingService, FeignCarService feignCarService, FeignUserService feignUserService) {
        this.bookingService = bookingService;
        this.feignCarService = feignCarService;
        this.feignUserService = feignUserService;
    }

    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> getAvailableCars() {
        List<CarDto> availableCars = feignCarService.getAvailableCars();
        return new ResponseEntity<>(availableCars, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> makeABooking(@RequestBody BookingDto bookingDto, @PathVariable(name = "id") Long carId) {
        Long myAccountId = feignUserService.getLoggedUserId();
        bookingService.makeABooking(bookingDto, myAccountId, carId);
        return new ResponseEntity<>("Booking successful!", HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<BookingDto>> getMyBookings() {
        List<BookingDto> myBookings = bookingService.getMyBookings();
        return new ResponseEntity<>(myBookings, HttpStatus.OK);
    }
}