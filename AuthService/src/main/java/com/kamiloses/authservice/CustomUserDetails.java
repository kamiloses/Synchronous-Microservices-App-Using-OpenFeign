package com.kamiloses.authservice;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomUserDetails implements UserDetailsService {

    private final FeignUserService userService;

    public CustomUserDetails(FeignUserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto user = userService.loadUsernameFromDB(username).orElseThrow(() -> new UsernameNotFoundException("This user does not exist"));
        System.out.println(user);
        return new User(
                user.getUsername(),
                user.getPassword(),
                roleToGrantedAuthority(user)
        );
    }

    private List<GrantedAuthority> roleToGrantedAuthority(UserDto user) {
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority(user.getRole().toString()));
        return list;
    }
}