package com.kamiloses.carinventoryservice.service;

import com.kamiloses.carinventoryservice.dto.CarDto;
import com.kamiloses.carinventoryservice.entity.CarEntity;
import com.kamiloses.carinventoryservice.entity.CarStatus;
import com.kamiloses.carinventoryservice.exception.VehicleNotFoundException;
import com.kamiloses.carinventoryservice.repository.CarRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final Mapper mapper;
    private final CarRepository carRepository;

    public CarService(Mapper mapper, CarRepository carRepository) {
        this.mapper = mapper;
        this.carRepository = carRepository;
    }

    public void addCarToService(CarDto carDto) {
        CarEntity carEntity = new CarEntity();
        CarEntity car = mapper.mapCarDtoToEntity(carEntity,carDto);

        carRepository.save(car);

    }


    public void removeCarFromService(Long id) {
 if (!carRepository.existsById(id)){throw new VehicleNotFoundException("The car does not exist in our service");}
      carRepository.deleteById(id);

    }
    //put
    public void modifyCar(Long id,CarDto carDto){
        CarEntity carEntity = carRepository.findById(id).orElseThrow(() -> new VehicleNotFoundException("The car does not exist in our service"));
        CarEntity car = mapper.mapCarDtoToEntity(carEntity,carDto);
        carRepository.save(car);

    }
    //patch
     public void modifyCarStatus(Long id){
         CarEntity carEntity = carRepository.findById(id).orElseThrow(() -> new VehicleNotFoundException("The car does not exist in our service"));
         CarStatus currentStatus = carEntity.getCarStatus();


         if (currentStatus.equals(CarStatus.IN_MAINTENANCE)) {
             carEntity.setCarStatus(CarStatus.AVAILABLE);
         } else if (currentStatus.equals(CarStatus.RENTED)) {
             carEntity.setCarStatus(CarStatus.IN_MAINTENANCE);
         } else if (currentStatus.equals(CarStatus.AVAILABLE)) {
             carEntity.setCarStatus(CarStatus.RENTED);
         }


         carRepository.save(carEntity);


     }
     public List<CarDto> getAllCars(){

        return mapper.mapCarEntityToDto(carRepository.findAll());

     }

     public List<CarDto> getAllAvailableCars(){

        return mapper.mapCarEntityToDto(carRepository.findAll()).stream()
                .filter(carDto -> carDto.getCarStatus().equals(CarStatus.AVAILABLE)).toList();

    }
    public List<CarDto> getCarsByBrand(String brand){
        return mapper.mapCarEntityToDto(carRepository.findAll()).stream().filter(carDto ->carDto.getBrand().equals(brand)).toList();
    }





}