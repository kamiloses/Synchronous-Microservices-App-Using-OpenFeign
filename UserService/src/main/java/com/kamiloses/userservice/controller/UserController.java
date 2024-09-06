package com.kamiloses.userservice.controller;

import com.kamiloses.userservice.UserDto;
import com.kamiloses.userservice.UserService;
import com.kamiloses.userservice.repository.UserRepository;
import com.kamiloses.userservice.service.Mapper;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {//todo napisz potem w readme że w tej aplikacji nie używałem validacji


    private final UserService userService;
    private final Mapper mapper;
    private final UserRepository userRepository;
//todo potem dodaj do serwisu
    public UserController(UserService userService, Mapper mapper, UserRepository userRepository) {
        this.userService = userService;
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    @PostMapping
    public String createAnAccount(@RequestBody UserDto userDto) {
        userService.createAnAccount(userDto);

        return "User created successfully";
    }
//todo dodaj logowanie itp





    @GetMapping("/load")
    public Optional<UserDto> loadUsernameFromDB(@RequestParam String username){
        return mapper.userEntityToDto(userRepository.findByUsername(username));

    }


}
