package com.kamiloses.userservice.repository;

import com.kamiloses.userservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {


//  UserEntity findByUsername(String username);
  void deleteByUsername(String username);

}
