package com.finalproject.hotelbookingsystem.controller;

import com.finalproject.hotelbookingsystem.dto.BookingRequestDto;
import com.finalproject.hotelbookingsystem.dto.BookingResponseDto;
import com.finalproject.hotelbookingsystem.dto.BookingUpdateDto;
import com.finalproject.hotelbookingsystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @PostMapping
    public BookingResponseDto createBooking(@RequestBody BookingRequestDto booking) {
        return bookingService.createBooking(booking);
    }
    @GetMapping("/{bookingId}")
    public BookingResponseDto getBookingById(@PathVariable Long bookingId) {
        return bookingService.getBookingById(bookingId);
    }
    @GetMapping("/bookings")
    public List<BookingResponseDto> getAllBookings(){
        return bookingService.getAllBookings();
    }
    @PutMapping("/{bookingId}")
    public BookingResponseDto updateBooking(@PathVariable Long bookingId, @RequestBody BookingUpdateDto booking) {
        return bookingService.updateBooking(bookingId, booking);
    }
    @DeleteMapping("/{bookingId}")
    public void cancelBooking(@PathVariable Long bookingId) {
        bookingService.cancelBooking(bookingId);
    }
}
