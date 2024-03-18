package com.finalproject.hotelbookingsystem.dto;

import jakarta.persistence.ManyToOne;
import org.springframework.web.bind.annotation.ModelAttribute;

public class RoomDto {
    private String roomType;
    @ManyToOne
    private HotelDto hotelDto;


    private String status="vacate";

    public RoomDto(String roomType, HotelDto hotelDto, String status) {
        this.roomType = roomType;
        this.hotelDto = hotelDto;
        this.status = status;
    }

    public RoomDto() {
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public HotelDto getHotelDto() {
        return hotelDto;
    }

    public void setHotelDto(HotelDto hotelDto) {
        this.hotelDto = hotelDto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
