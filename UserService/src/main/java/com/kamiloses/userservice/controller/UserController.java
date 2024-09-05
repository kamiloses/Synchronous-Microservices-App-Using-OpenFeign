package com.kamiloses.userservice.controller;

import com.kamiloses.userservice.UserDto;
import com.kamiloses.userservice.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {//todo napisz potem w readme że w tej aplikacji nie używałem validacji


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String createAnAccount(@RequestBody UserDto userDto) {
        userService.createAnAccount(userDto);

        return "User created successfully";
    }
//todo dodaj logowanie itp



}
