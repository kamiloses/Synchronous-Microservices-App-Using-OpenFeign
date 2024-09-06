package com.kamiloses.userservice.repository;

import com.kamiloses.userservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {


//  UserEntity findByUsername(String username);
  void deleteByUsername(String username);

    Optional<UserEntity> findByUsername(String username);
}
