package com.kamiloses.carinventoryservice.controller;

import com.kamiloses.carinventoryservice.dto.CarDto;
import com.kamiloses.carinventoryservice.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<String> addCarToService(@RequestBody CarDto carDto) {
        carService.addCarToService(carDto);
        return new ResponseEntity<>("The car has been successfully added to our service", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeCarFromService(@PathVariable Long id) {
        carService.removeCarFromService(id);
        return new ResponseEntity<>("The car has been successfully removed from our service", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> modifyCar(@PathVariable Long id, @RequestBody CarDto carDto) {
        carService.modifyCar(id, carDto);
        return new ResponseEntity<>("The car has been successfully modified in our service", HttpStatus.OK);
    }

    @PutMapping("/{id}/status")// i have used put because openfeign does not support patch
    public ResponseEntity<String> modifyCarStatus(@PathVariable Long id) {
        carService.modifyCarStatus(id);
        return new ResponseEntity<>("The car status has been successfully modified in our service", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CarDto>> getAllCars() {
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/available")
    public ResponseEntity<List<CarDto>> getAllAvailableCars() {
        return new ResponseEntity<>(carService.getAllAvailableCars(), HttpStatus.OK);
    }

    @GetMapping("/{brand}")
    public ResponseEntity<List<CarDto>> getCarsByBrand(@PathVariable String brand) {
        return new ResponseEntity<>(carService.getCarsByBrand(brand), HttpStatus.OK);
    }
}