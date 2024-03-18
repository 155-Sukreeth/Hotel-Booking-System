package com.finalproject.hotelbookingsystem.dto;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelDto {

        private String name;
        private String address;
        @OneToMany
        private RoomDto roomDto;

    }


