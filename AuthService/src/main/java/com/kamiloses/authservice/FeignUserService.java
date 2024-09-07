package com.kamiloses.authservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient("USERSERVICE")
public interface FeignUserService {


    @GetMapping("/user/load")
    Optional<UserDto> loadUsernameFromDB(@RequestParam String username);

}

