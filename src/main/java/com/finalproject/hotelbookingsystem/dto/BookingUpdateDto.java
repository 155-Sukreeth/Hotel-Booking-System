package com.finalproject.hotelbookingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingUpdateDto {
    private Integer roomId;
    private Integer duration;
}
