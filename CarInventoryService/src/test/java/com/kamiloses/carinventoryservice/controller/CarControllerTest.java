package com.kamiloses.carinventoryservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kamiloses.carinventoryservice.dto.CarDto;
import com.kamiloses.carinventoryservice.entity.CarEntity;
import com.kamiloses.carinventoryservice.enums.CarStatus;
import com.kamiloses.carinventoryservice.enums.FuelType;
import com.kamiloses.carinventoryservice.repository.CarRepository;
import com.kamiloses.carinventoryservice.service.Mapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class CarControllerTest {
//todo dodaj baze testową
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private Mapper mapper;
    private CarDto carDto;


    @BeforeEach
    void setUp() {
        carRepository.deleteAll();

        carDto = new CarDto();
        carDto.setBrand("Toyota");
        carDto.setModel("Corolla");
        carDto.setYear(Year.of(2020));
        carDto.setCarStatus(CarStatus.AVAILABLE);
        carDto.setDailyRate(49.99);
        carDto.setFuelType(FuelType.PETROL);
        carDto.setMileage(30000);
    }

    @Test
    void testAddCarToService() throws Exception {
        mockMvc.perform(post("/cars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(carDto)))
                .andExpect(status().isCreated())
                .andExpect(content().string("The car has been successfully added to our service"));

        assertEquals(1, carRepository.count());
    }



    @Test
    void testModifyCar() throws Exception {
        CarEntity carEntity = new CarEntity();
        carDto.setMileage(35000);
        CarEntity saved = carRepository.save(mapper.mapCarDtoToEntity(carEntity, carDto));


        mockMvc.perform(put("/cars/{id}", saved.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(carDto)))
                .andExpect(status().isOk())
                .andExpect(content().string("The car has been successfully modified in our service"));

    }

    @Test
    void testModifyCarStatus() throws Exception {
        CarEntity carEntity = new CarEntity();
        CarEntity saved = carRepository.save(mapper.mapCarDtoToEntity(carEntity, carDto));

        mockMvc.perform(patch("/cars/{id}/status", saved.getId())
                        .param("carStatus", "IN_MAINTENANCE"))
                .andExpect(status().isOk())
                .andExpect(content().string("The car status has been successfully modified in our service"));

    }

    @Test
    void testGetAllCars() throws Exception {
        CarEntity carEntity = new CarEntity();
        carRepository.save(mapper.mapCarDtoToEntity(carEntity,carDto));

        mockMvc.perform(get("/cars"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].brand").value("Toyota"));
    }

    @Test
    void testGetAllAvailableCars() throws Exception {
        CarEntity carEntity = new CarEntity();
        carRepository.save(mapper.mapCarDtoToEntity(carEntity,carDto));

        mockMvc.perform(get("/cars/available"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].brand").value("Toyota"));
    }

    @Test
    void testGetCarsByBrand() throws Exception {
        CarEntity carEntity = new CarEntity();
        carRepository.save(mapper.mapCarDtoToEntity(carEntity,carDto));

        mockMvc.perform(get("/cars/brand").param("brand", "Toyota"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].brand").value("Toyota"));
    }
}
