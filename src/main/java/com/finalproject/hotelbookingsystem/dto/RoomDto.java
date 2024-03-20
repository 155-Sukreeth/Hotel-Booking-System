package com.finalproject.hotelbookingsystem.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    @NotEmpty(message = "Room Type can not be empty. Enter room Type")
    private String roomType;
    private Integer hotelId;
    private String status="Vacant";
}
