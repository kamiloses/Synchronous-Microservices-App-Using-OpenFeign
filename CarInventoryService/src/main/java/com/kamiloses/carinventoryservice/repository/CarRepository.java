package com.kamiloses.carinventoryservice.repository;

import com.kamiloses.carinventoryservice.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity,Long> {



}
