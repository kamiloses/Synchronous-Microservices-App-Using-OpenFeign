package com.kamiloses.bookingservice.controller;

import com.kamiloses.bookingservice.dto.BookingDto;
import com.kamiloses.bookingservice.dto.CarDto;
import com.kamiloses.bookingservice.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;
    private final OpenFeign openFeign;

    public BookingController(BookingService bookingService, OpenFeign openFeign) {
        this.bookingService = bookingService;
        this.openFeign = openFeign;
    }
@PostMapping("/{id}")
    public String makeABooking(@RequestBody BookingDto bookingDto,@PathVariable(name = "id") Long carId){

    bookingService.makeABooking(bookingDto,carId);


return "success";
}
@DeleteMapping
public String cancelABooking(){



return null;}


    @GetMapping("/cars") //todo zmień na responseEntity
    public List<CarDto> getAvailableCars(){
     return openFeign.getAvailableCars();

    }


  /*  @GetMapping("")
    public list<CarDto>getMyBookiing(){

    }*/





}
