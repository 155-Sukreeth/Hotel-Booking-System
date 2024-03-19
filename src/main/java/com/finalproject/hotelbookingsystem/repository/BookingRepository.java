package com.finalproject.hotelbookingsystem.repository;

import com.finalproject.hotelbookingsystem.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

}
