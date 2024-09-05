package com.kamiloses.userservice.controller;

import com.kamiloses.userservice.UserDto;
import com.kamiloses.userservice.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserControllerConfig {
    //todo zrób wspólną biblioteke dto dla wszystkich modułów
    private final UserRepository userRepository;

    public UserControllerConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/config")//this annotation is //todo dokoncz
    public Long getMyAccountId() {
        // String username = SecurityContextHolder.getContext().getName();
        // Long  id =userRepository.findIdByUsername(username);

        return 75L;


    }
}
