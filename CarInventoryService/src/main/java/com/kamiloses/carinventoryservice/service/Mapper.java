package com.kamiloses.carinventoryservice.service;

import com.kamiloses.carinventoryservice.dto.CarDto;
import com.kamiloses.carinventoryservice.entity.CarEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Mapper {


    public CarEntity mapCarDtoToEntity(CarEntity carEntity, CarDto carDto) {
        carEntity.setBrand(carDto.getBrand());
        carEntity.setModel(carDto.getModel());
        carEntity.setYear(carDto.getYear());
        carEntity.setCarStatus(carDto.getCarStatus());
        carEntity.setDailyRate(carDto.getDailyRate());
        carEntity.setFuelType(carDto.getFuelType());
        carEntity.setMileage(carDto.getMileage());


        return carEntity;
    }


    public List<CarDto> mapCarEntityToDto(List<CarEntity> carEntities) {
        return carEntities.stream().map(carEntity -> {
            CarDto carDto = new CarDto();
            carDto.setId(carEntity.getId());
            carDto.setBrand(carEntity.getBrand());
            carDto.setModel(carEntity.getModel());
            carDto.setYear(carEntity.getYear());
            carDto.setCarStatus(carEntity.getCarStatus());
            carDto.setDailyRate(carEntity.getDailyRate());
            carDto.setFuelType(carEntity.getFuelType());
            carDto.setMileage(carEntity.getMileage());


            return carDto;
        }).toList();
    }

}
