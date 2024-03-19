package com.finalproject.hotelbookingsystem.service;

import com.finalproject.hotelbookingsystem.dto.BookingDto;
import com.finalproject.hotelbookingsystem.dto.BookingUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookingService {
    BookingDto updateBooking(Long bookingId, BookingUpdateDto booking);
    BookingDto createBooking(BookingDto booking);
    void cancelBooking(Long bookingId);
    BookingDto getBookingById(Long bookingId);
    List<BookingDto> getAllBookings();
}
