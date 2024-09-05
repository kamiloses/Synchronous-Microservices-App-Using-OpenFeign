package com.kamiloses.bookingservice.service;

import com.kamiloses.bookingservice.dto.BookingDto;
import com.kamiloses.bookingservice.entity.BookingEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Mapper {

    public BookingEntity BookingDtoToEntity(BookingDto bookingDto){
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setStartDate(bookingDto.getStartDate());
        bookingEntity.setEndDate(bookingDto.getEndDate());
        //bookingEntity.setStatus(); //todo potem ustaw status
        //bookingEntity.setCarId();

    return bookingEntity;}


    public List<BookingDto> BookingEntityToDto(List<BookingEntity> bookingEntities) {
        return bookingEntities.stream()
                .map(bookingEntity -> new BookingDto(
                        bookingEntity.getId(),
                        bookingEntity.getStartDate(),
                        bookingEntity.getEndDate(),
                        bookingEntity.getStatus())).toList();
    }



}
