package com.finalproject.hotelbookingsystem.controller;


import com.finalproject.hotelbookingsystem.dto.HotelDto;
import com.finalproject.hotelbookingsystem.dto.RoomDto;
import com.finalproject.hotelbookingsystem.service.HotelService;
import com.finalproject.hotelbookingsystem.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private  RoomService roomService;

    private static final Logger logger= LoggerFactory.getLogger(RoomController.class);

    @GetMapping("/rooms/{id}")
    public RoomDto getRoomById(@PathVariable("id") int roomId) {
        logger.info("RoomController is called");
        return roomService.getRoomById(roomId);
    }

    @GetMapping("/rooms")
    public List<RoomDto> getAllRooms() {

        return roomService.getAllRooms();
    }

    @PostMapping("/rooms")
    public RoomDto createRoom(@RequestBody RoomDto roomDto)
    {
        return roomService.createRoom(roomDto);
    }
    @PutMapping("/rooms/{id}")
    public RoomDto updateRoomById(@PathVariable("id") int roomId ,@RequestBody RoomDto roomDto) {

        return roomService.updateRoomById(roomId,roomDto);
    }

    @DeleteMapping("/rooms/{id}")
    public String deleteRoomById(@PathVariable("id") int roomId) {
        return roomService.deleteRoomById(roomId);

    }
}
