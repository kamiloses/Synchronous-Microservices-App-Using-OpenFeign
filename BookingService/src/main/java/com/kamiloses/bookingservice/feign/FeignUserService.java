package com.kamiloses.bookingservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("USERSERVICE")
public interface FeignUserService {


    @GetMapping("/user/config")
    Long getLoggedUserId();

}
