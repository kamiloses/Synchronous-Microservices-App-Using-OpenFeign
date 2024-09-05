package com.kamiloses.bookingservice.repository;

import com.kamiloses.bookingservice.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity,Long> {



    List<BookingEntity> findByUserId(Long userId);


}
