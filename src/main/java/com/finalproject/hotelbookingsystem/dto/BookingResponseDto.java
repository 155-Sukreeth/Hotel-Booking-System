package com.finalproject.hotelbookingsystem.dto;

import com.finalproject.hotelbookingsystem.entity.CustomerEntity;
import com.finalproject.hotelbookingsystem.entity.HotelEntity;
import com.finalproject.hotelbookingsystem.entity.RoomEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponseDto {
    private Long bookingId;
    private Integer duration;
    private CustomerEntity customerEntity;
    private HotelEntity hotelEntity;
    private RoomEntity roomEntity;
}
