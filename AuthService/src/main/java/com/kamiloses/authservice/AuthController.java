package com.kamiloses.authservice;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {


@GetMapping("/config")
public String getLoggedUserUsername(){
return "jan";
    //    return SecurityContextHolder.getContext().getAuthentication().getName();

}



}
