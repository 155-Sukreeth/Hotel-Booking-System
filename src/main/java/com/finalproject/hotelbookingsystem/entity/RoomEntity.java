package com.finalproject.hotelbookingsystem.entity;

import com.finalproject.hotelbookingsystem.dto.HotelDto;
import jakarta.persistence.*;

@Entity
public class RoomEntity {

    @Id
    @GeneratedValue
    private int room_id;
    private String roomType;
    @JoinColumn(name="hotel_id")
    @ManyToOne()
    private HotelEntity hotelEntity;


    private String status="vacate";
}
