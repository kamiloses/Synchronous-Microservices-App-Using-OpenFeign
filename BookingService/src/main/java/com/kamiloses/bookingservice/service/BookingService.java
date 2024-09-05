package com.kamiloses.bookingservice.service;

import com.kamiloses.bookingservice.controller.FeignCarService;
import com.kamiloses.bookingservice.dto.BookingDto;
import com.kamiloses.bookingservice.entity.BookingEntity;
import com.kamiloses.bookingservice.entity.BookingStatus;
import com.kamiloses.bookingservice.repository.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class BookingService {

private final BookingRepository bookingRepository;
private final FeignCarService feignCarService; //todo zamień open feign nazwe na coś związanego z car

    public BookingService(BookingRepository bookingRepository, FeignCarService feignCarService) {
        this.bookingRepository = bookingRepository;
        this.feignCarService = feignCarService;
    }

    public void makeABooking(BookingDto bookingDto,Long userId,Long carId){
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setStartDate(bookingDto.getStartDate());
        bookingEntity.setEndDate(bookingDto.getEndDate());
        bookingEntity.setStatus(BookingStatus.PENDING);
        bookingEntity.setUserId(10L);//todo potem to zmień na userId
        bookingEntity.setCarId(carId);
        bookingRepository.save(bookingEntity);

        feignCarService.modifyCarStatus(carId);
    };
public void cancelABooking(Long id,Long userId){
    BookingEntity bookingEntity = bookingRepository.findById(id).orElseThrow(() -> new BookingNotFoundException());
    if (!bookingEntity.getUserId().equals(userId)){throw new BookingNotRelatedException() ;}
     bookingRepository.delete(bookingEntity);
}

//todo przez open feign niech sie wywoła metoda ze sprawdzaniem pojazdów dostępnych




}
