package com.finalproject.hotelbookingsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    @Column(name = "duration")
    private Integer duration;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;
    @OneToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotelEntity;
    @OneToOne
    @JoinColumn(name = "room_id")
    private RoomEntity roomEntity;
}
