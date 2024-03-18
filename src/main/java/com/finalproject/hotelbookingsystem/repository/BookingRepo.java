package com.finalproject.hotelbookingsystem.repository;

import com.finalproject.hotelbookingsystem.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepo extends JpaRepository<BookingEntity, Long> {
    List<BookingEntity> findByUserId(Long userId);
}
