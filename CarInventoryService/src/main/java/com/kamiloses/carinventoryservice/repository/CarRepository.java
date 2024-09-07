package com.kamiloses.carinventoryservice.repository;

import com.kamiloses.carinventoryservice.entity.CarEntity;
import com.kamiloses.carinventoryservice.enums.CarStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<CarEntity,Long> {

    List<CarEntity> findAllByCarStatus(CarStatus carStatus);
    List<CarEntity> findAllByBrand(String brand);



}
