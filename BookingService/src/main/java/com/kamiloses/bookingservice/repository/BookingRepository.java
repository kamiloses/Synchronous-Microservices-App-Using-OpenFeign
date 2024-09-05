package com.kamiloses.bookingservice.repository;

import com.kamiloses.bookingservice.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingEntity,Long> {
}
