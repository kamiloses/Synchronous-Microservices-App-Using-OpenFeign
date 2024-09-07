package com.kamiloses.bookingservice.service;

import com.kamiloses.bookingservice.exception.BookingNotFoundException;
import com.kamiloses.bookingservice.feign.FeignCarService;
import com.kamiloses.bookingservice.feign.FeignUserService;
import com.kamiloses.bookingservice.dto.BookingDto;
import com.kamiloses.bookingservice.entity.BookingEntity;
import com.kamiloses.bookingservice.enums.BookingStatus;
import com.kamiloses.bookingservice.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final FeignCarService feignCarService;
    private final Mapper mapper;
    private final FeignUserService feignUserService;

    public BookingService(BookingRepository bookingRepository, FeignCarService feignCarService, Mapper mapper, FeignUserService feignUserService) {
        this.bookingRepository = bookingRepository;
        this.feignCarService = feignCarService;
        this.mapper = mapper;
        this.feignUserService = feignUserService;
    }

    public void makeABooking(BookingDto bookingDto, Long userId, Long carId) {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setStartDate(bookingDto.getStartDate());
        bookingEntity.setEndDate(bookingDto.getEndDate());
        bookingEntity.setStatus(BookingStatus.PENDING);
        bookingEntity.setUserId(userId);
        bookingEntity.setCarId(carId);
        bookingRepository.save(bookingEntity);

        feignCarService.modifyCarStatus(carId);
    }

    ;

    public void cancelABooking(Long id, Long userId) {
        BookingEntity bookingEntity = bookingRepository.findById(id)
                .filter(booking -> booking.getUserId().equals(userId))
                .orElseThrow(() -> new BookingNotFoundException("This booking is not existing or it's not related with you"));
        bookingRepository.delete(bookingEntity);
    }



    public List<BookingDto> getMyBookings() {
        Long myAccountId = feignUserService.getLoggedUserId();
        return mapper.BookingEntityToDto(bookingRepository.findByUserId(myAccountId));


    }

}
