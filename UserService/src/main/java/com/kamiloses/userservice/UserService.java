package com.kamiloses.userservice;

import com.kamiloses.userservice.entity.UserEntity;
import com.kamiloses.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import static com.kamiloses.userservice.entity.Role.ROLE_USER;

@Service
public class UserService {

private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createAnAccount(UserDto userDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setRole(ROLE_USER);
        userEntity.setMoney(0.00);

          userRepository.save(userEntity);
    }

public void deleteAnAccount(String username){
        userRepository.deleteByUsername(username);

}

}