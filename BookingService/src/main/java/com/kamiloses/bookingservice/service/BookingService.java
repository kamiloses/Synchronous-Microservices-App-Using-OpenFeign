package com.kamiloses.bookingservice.service;

import com.kamiloses.bookingservice.controller.OpenFeign;
import com.kamiloses.bookingservice.dto.BookingDto;
import com.kamiloses.bookingservice.entity.BookingEntity;
import com.kamiloses.bookingservice.entity.BookingStatus;
import com.kamiloses.bookingservice.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

private final BookingRepository bookingRepository;
private final OpenFeign openFeign; //todo zamień open feign nazwe na coś związanego z car

    public BookingService(BookingRepository bookingRepository, OpenFeign openFeign) {
        this.bookingRepository = bookingRepository;
        this.openFeign = openFeign;
    }

    public void makeABooking(BookingDto bookingDto,Long carId){
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setStartDate(bookingDto.getStartDate());
        bookingEntity.setEndDate(bookingDto.getEndDate());
        bookingEntity.setStatus(BookingStatus.PENDING);
        bookingRepository.save(bookingEntity);

        openFeign.modifyCarStatus(carId);
    };
public void cancelABooking(){

}

//todo przez open feign niech sie wywoła metoda ze sprawdzaniem pojazdów dostępnych


}
