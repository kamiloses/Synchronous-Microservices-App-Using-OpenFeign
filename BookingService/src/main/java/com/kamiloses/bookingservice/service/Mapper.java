package com.kamiloses.bookingservice.service;

import com.kamiloses.bookingservice.dto.BookingDto;
import com.kamiloses.bookingservice.entity.BookingEntity;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public BookingEntity BookingDtoToEntity(BookingDto bookingDto){
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setStartDate(bookingDto.getStartDate());
        bookingEntity.setEndDate(bookingDto.getEndDate());
        //bookingEntity.setStatus(); //todo potem ustaw status
        //bookingEntity.setCarId();

    return bookingEntity;}





}
