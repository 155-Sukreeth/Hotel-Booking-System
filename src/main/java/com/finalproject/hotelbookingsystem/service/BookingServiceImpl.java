package com.finalproject.hotelbookingsystem.service;

import com.finalproject.hotelbookingsystem.dto.BookingDto;
import com.finalproject.hotelbookingsystem.entity.BookingEntity;
import com.finalproject.hotelbookingsystem.exceptions.BookingIdDoesNotExistException;
import com.finalproject.hotelbookingsystem.repository.BookingRepository;
import org.modelmapper.ModelMapper;

import java.util.Optional;

public class BookingServiceImpl implements BookingService{
    private BookingRepository bookingRepo;
    private ModelMapper modelMapper;
    @Override
    public BookingDto updateBooking(Long bookingId, BookingDto bookingDto) {
        BookingEntity bookingEntity = bookingRepo.save(modelMapper.map(bookingDto, BookingEntity.class));
        return modelMapper.map(bookingEntity, BookingDto.class);
    }

    @Override
    public BookingDto createBooking(BookingDto bookingDto) {
        BookingEntity bookingEntity = bookingRepo.save(modelMapper.map(bookingDto, BookingEntity.class));
        return modelMapper.map(bookingEntity, BookingDto.class);
    }

    @Override
    public void cancelBooking(Long bookingId) {
        bookingRepo.deleteById(bookingId);
    }

    @Override
    public BookingDto getBookingById(Long bookingId) {
        Optional<BookingEntity> bookingEntity = bookingRepo.findById(bookingId);
        if(bookingEntity.isEmpty()){
            throw new BookingIdDoesNotExistException("Booking ID not found");
        }
        return modelMapper.map(bookingEntity.get(), BookingDto.class);
    }
}
