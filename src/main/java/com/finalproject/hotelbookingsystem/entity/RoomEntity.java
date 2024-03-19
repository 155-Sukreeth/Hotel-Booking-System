package com.finalproject.hotelbookingsystem.entity;

import com.finalproject.hotelbookingsystem.dto.HotelDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomEntity {
    @Id
    @GeneratedValue
    @Column(name = "room_id")
    private Integer roomId;
    @Column(name = "room_type")
    private String roomType;
    @JoinColumn(name="hotel_id")
    @ManyToOne
    private HotelEntity hotelEntity;
    @Column(name = "status")
    private String status="vacate";
}
