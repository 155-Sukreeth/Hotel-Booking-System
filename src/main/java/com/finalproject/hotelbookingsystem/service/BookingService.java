package com.finalproject.hotelbookingsystem.service;

import com.finalproject.hotelbookingsystem.dto.BookingDto;

public interface BookingService {
    BookingDto updateBooking(Long bookingId, BookingDto booking);

    BookingDto createBooking(BookingDto booking);

    void cancelBooking(Long bookingId);

    BookingDto getBookingById(Long bookingId);
}
