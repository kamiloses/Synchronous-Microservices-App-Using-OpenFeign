package com.kamiloses.userservice.service;

import com.kamiloses.userservice.UserDto;
import com.kamiloses.userservice.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Mapper {


    public Optional<UserDto> userEntityToDto(Optional<UserEntity> userEntity) {
        if (userEntity.isPresent()) {
            UserEntity entity = userEntity.get();
            return Optional.of(new UserDto(entity.getUsername(), entity.getPassword(), entity.getRole()));
        } else {
            return Optional.empty();
        }
    }
    }

