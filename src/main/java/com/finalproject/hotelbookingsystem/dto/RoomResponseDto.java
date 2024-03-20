package com.finalproject.hotelbookingsystem.dto;

import com.finalproject.hotelbookingsystem.entity.HotelEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomResponseDto {
    private String roomType;
    private HotelDto hotelEntity;
    private String status="vacate";
}
