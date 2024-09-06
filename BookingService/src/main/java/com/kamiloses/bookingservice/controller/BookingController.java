package com.kamiloses.bookingservice.controller;

import com.kamiloses.bookingservice.dto.BookingDto;
import com.kamiloses.bookingservice.dto.CarDto;
import com.kamiloses.bookingservice.repository.BookingRepository;
import com.kamiloses.bookingservice.service.BookingService;
import com.kamiloses.bookingservice.service.Mapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;

    private final BookingRepository bookingRepository; //todo usuń repository potem

    private final Mapper mapper;
    private final FeignCarService feignCarService;
    private final FeignUserService feignUserService;

    public BookingController(BookingService bookingService, BookingRepository bookingRepository, Mapper mapper, FeignCarService feignCarService, FeignUserService feignUserService) {
        this.bookingService = bookingService;
        this.bookingRepository = bookingRepository;
        this.mapper = mapper;
        this.feignCarService = feignCarService;
        this.feignUserService = feignUserService;
    }

    @GetMapping("/cars") //todo zmień na responseEntity
    public List<CarDto> getAvailableCars() {
        return feignCarService.getAvailableCars();

    }


    @PostMapping("/{id}")
    public String makeABooking(@RequestBody BookingDto bookingDto, @PathVariable(name = "id") Long carId) {
        Long myAccountId = feignUserService.getMyAccountId();
        bookingService.makeABooking(bookingDto, myAccountId, carId);


        return "success";
    }

    @DeleteMapping("/{id}")
    public String cancelABooking(@PathVariable(name = "id") Long bookingId) {
        Long myAccountId = feignUserService.getMyAccountId();
        bookingService.cancelABooking(bookingId, myAccountId);


        return null;
    }

    @GetMapping
    public List<BookingDto> getMyBookings() {
        Long myAccountId = feignUserService.getMyAccountId();
        return mapper.BookingEntityToDto(bookingRepository.findByUserId(myAccountId));
        //zwraca to wszystkie moje zamówienia

    }





}
