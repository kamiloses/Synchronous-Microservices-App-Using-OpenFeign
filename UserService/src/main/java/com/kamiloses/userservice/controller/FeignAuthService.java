package com.kamiloses.userservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("AUTHSERVICE")
public interface FeignAuthService {

    //@GetMapping("/booking")
    // List<UserRentalDto> getMyBookings();

    @GetMapping("/auth/config")
    String getLoggedUserUsername();


}
