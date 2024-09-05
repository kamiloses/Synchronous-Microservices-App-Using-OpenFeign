package com.kamiloses.bookingservice.service;

import com.kamiloses.bookingservice.entity.BookingEntity;
import com.kamiloses.bookingservice.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public void makeBooking(){
bookingRepository.save(new BookingEntity());

};
public void cancelBooking(){

}

//todo przez open feign niech sie wywoła metoda ze sprawdzaniem pojazdów dostępnych


}
