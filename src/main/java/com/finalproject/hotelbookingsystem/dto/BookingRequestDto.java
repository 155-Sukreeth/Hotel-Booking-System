package com.finalproject.hotelbookingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequestDto {
    private Integer duration;
    private Long customerId;
    private Integer hotelId;
    private Integer roomId;
}
