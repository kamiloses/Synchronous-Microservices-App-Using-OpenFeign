package com.kamiloses.bookingservice.controller;

import com.kamiloses.bookingservice.dto.CarDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("CARINVENTORYSERVICE")
public interface OpenFeign {


    @GetMapping("/cars/available")
    List<CarDto> getAvailableCars();

    @PutMapping("/cars/{id}/status")
    String modifyCarStatus(@PathVariable Long id);


}
