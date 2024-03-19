package com.finalproject.hotelbookingsystem.controller;

import com.finalproject.hotelbookingsystem.dto.BookingDto;
import com.finalproject.hotelbookingsystem.dto.BookingUpdateDto;
import com.finalproject.hotelbookingsystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public BookingDto createBooking(@RequestBody BookingDto booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping("/{bookingId}")
    public BookingDto getBookingById(@PathVariable Long bookingId) {
        return bookingService.getBookingById(bookingId);
    }

    @GetMapping("/bookings")
    public List<BookingDto> getAllBookings(){
        return bookingService.getAllBookings();
    }
    @PutMapping("/{bookingId}")
    public BookingDto updateBooking(@PathVariable Long bookingId, @RequestBody BookingUpdateDto booking) {
        return bookingService.updateBooking(bookingId, booking);
    }

    @DeleteMapping("/{bookingId}")
    public void cancelBooking(@PathVariable Long bookingId) {
        bookingService.cancelBooking(bookingId);
    }
}
