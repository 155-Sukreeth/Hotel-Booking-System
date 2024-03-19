package com.finalproject.hotelbookingsystem.entity;

import com.finalproject.hotelbookingsystem.dto.HotelDto;
import jakarta.persistence.*;

@Entity
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;
    private String roomType;
    @JoinColumn(name="hotelId")
    @ManyToOne
    private HotelEntity hotelEntity;


    private String status="vacate";
}
