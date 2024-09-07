package com.kamiloses.userservice.controller;

import com.kamiloses.userservice.UserDto;
import com.kamiloses.userservice.UserService;
import com.kamiloses.userservice.repository.UserRepository;
import com.kamiloses.userservice.service.Mapper;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;
    private final Mapper mapper;
    private final UserRepository userRepository;
    private final FeignAuthService feignAuthService;
//todo potem dodaj do serwisu

    public UserController(UserService userService, Mapper mapper, UserRepository userRepository, FeignAuthService feignAuthService) {
        this.userService = userService;
        this.mapper = mapper;
        this.userRepository = userRepository;
        this.feignAuthService = feignAuthService;
    }

    @PostMapping
    public String createAnAccount(@RequestBody UserDto userDto) {
        userService.createAnAccount(userDto);

        return "User created successfully";
    }






    @GetMapping("/load")
    public Optional<UserDto> loadUsernameFromDB(@RequestParam String username){
        return mapper.userEntityToDto(userRepository.findByUsername(username));

    }
    @GetMapping("/config")
    public Long getLoggedUserId(){
        String loggedUserUsername = feignAuthService.getLoggedUserUsername();
        System.out.println(loggedUserUsername);
        return userRepository.findByUsername(loggedUserUsername).get().getId();
    }


}
