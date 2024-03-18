package com.finalproject.hotelbookingsystem.controller;


import com.finalproject.hotelbookingsystem.dto.HotelDto;
import com.finalproject.hotelbookingsystem.dto.RoomDto;
import com.finalproject.hotelbookingsystem.service.HotelService;
import com.finalproject.hotelbookingsystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room-api/v1")
public class RoomController {

    @Autowired
    private  RoomService roomService;



    @GetMapping("/room-api/v1/{id}")
    public RoomDto getRoomById(@PathVariable("id") int room_id) {
        return roomService.getRoomById(room_id);
    }

    @GetMapping
    public List<RoomDto> getAllRooms() {
        return roomService.getAllRooms();
    }


    @PutMapping("/rooms/{id}")
    public RoomDto updateRoomById(@PathVariable("id") int room_id) {
        return roomService.updateRoomById(room_id);
    }

    @DeleteMapping("/rooms/{id}")
    public RoomDto deleteRoomById(@PathVariable("id") int room_id) {
        return roomService.deleteRoomById(room_id);

    }
}
