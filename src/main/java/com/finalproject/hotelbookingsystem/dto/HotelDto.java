package com.finalproject.hotelbookingsystem.dto;

import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelDto {
        @NotEmpty(message = "HotelName cannot empty !! enter the Hotel name")
        private String name;
        @NotEmpty(message = "address cannot be empty . Enter the  address")
        private String address;
    }



