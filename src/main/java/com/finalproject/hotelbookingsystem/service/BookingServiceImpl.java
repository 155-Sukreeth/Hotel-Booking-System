package com.finalproject.hotelbookingsystem.service;

import com.finalproject.hotelbookingsystem.dto.BookingDto;
import com.finalproject.hotelbookingsystem.dto.BookingUpdateDto;
import com.finalproject.hotelbookingsystem.entity.BookingEntity;
import com.finalproject.hotelbookingsystem.entity.RoomEntity;
import com.finalproject.hotelbookingsystem.exceptions.BookingIdDoesNotExistException;
import com.finalproject.hotelbookingsystem.repository.BookingRepository;
import com.finalproject.hotelbookingsystem.repository.RoomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{
    private final BookingRepository bookingRepo;
    private final RoomRepository roomRepo;
    private final ModelMapper modelMapper;
    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepo, RoomRepository roomRepo, ModelMapper modelMapper) {
        this.bookingRepo = bookingRepo;
        this.roomRepo = roomRepo;
        this.modelMapper = modelMapper;
    }
    @Override
    public BookingDto updateBooking(Long bookingId, BookingUpdateDto bookingUpdateDto) {
        Optional<BookingEntity> optionalBookingEntity = bookingRepo.findById(bookingId);
        if (optionalBookingEntity.isPresent()) {
            BookingEntity bookingEntity = optionalBookingEntity.get();
            RoomEntity oldRoomEntity = bookingEntity.getRoomEntity();
            if (oldRoomEntity != null) {
                oldRoomEntity.setStatus("Vacant");
                roomRepo.save(oldRoomEntity);
            }

            bookingEntity.setDuration(bookingUpdateDto.getDuration());

            Optional<RoomEntity> optionalRoomEntity = roomRepo.findById(bookingUpdateDto.getRoomId());
            if(optionalRoomEntity.isPresent()){
                RoomEntity newRoomEntity = optionalRoomEntity.get();
                newRoomEntity.setStatus("Booked");
                bookingEntity.setRoomEntity(newRoomEntity);
            }
            BookingEntity updatedBookingEntity = bookingRepo.save(bookingEntity);
            return modelMapper.map(updatedBookingEntity, BookingDto.class);
        } else {
            throw new BookingIdDoesNotExistException("Booking ID does not exist");
        }
    }
    @Override
    public BookingDto createBooking(BookingDto bookingDto) {
        BookingEntity bookingEntity = bookingRepo.save(modelMapper.map(bookingDto, BookingEntity.class));
        return modelMapper.map(bookingEntity, BookingDto.class);
    }
    @Override
    public void cancelBooking(Long bookingId) {
        Optional<BookingEntity> optionalBookingEntity = bookingRepo.findById(bookingId);
        if (optionalBookingEntity.isPresent()) {
            BookingEntity bookingEntity = optionalBookingEntity.get();
            RoomEntity oldRoomEntity = bookingEntity.getRoomEntity();
            if (oldRoomEntity != null) {
                oldRoomEntity.setStatus("Vacant");
                roomRepo.save(oldRoomEntity);
            }
            bookingRepo.deleteById(bookingId);
        } else {
            throw new BookingIdDoesNotExistException("Booking ID does not exist");
        }
    }
    @Override
    public BookingDto getBookingById(Long bookingId) {
        Optional<BookingEntity> bookingEntity = bookingRepo.findById(bookingId);
        if(bookingEntity.isEmpty()){
            throw new BookingIdDoesNotExistException("Booking ID not found");
        }
        return modelMapper.map(bookingEntity.get(), BookingDto.class);
    }
    @Override
    public List<BookingDto> getAllBookings(){
        return bookingRepo.findAll()
                .stream()
                .map(e -> modelMapper.map(e, BookingDto.class))
                .toList();
    }
}
