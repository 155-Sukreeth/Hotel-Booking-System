package com.finalproject.hotelbookingsystem.controller;


import com.finalproject.hotelbookingsystem.dto.HotelDto;
import com.finalproject.hotelbookingsystem.dto.RoomDto;
import com.finalproject.hotelbookingsystem.dto.RoomResponseDto;
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
@RequestMapping("/room-api/v1")
public class RoomController {
    private final RoomService roomService;
    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
    private static final Logger logger= LoggerFactory.getLogger(RoomController.class);
    @GetMapping("/rooms/{id}")
    public RoomResponseDto getRoomById(@PathVariable("id") int roomId) {
        logger.info("RoomController is called");
        return roomService.getRoomById(roomId);
    }
    @GetMapping("/rooms")
    public List<RoomResponseDto> getAllRooms() {
        return roomService.getAllRooms();
    }
    @PostMapping("/rooms")
    public RoomResponseDto createRoom(@RequestBody RoomDto roomDto) {
        return roomService.createRoom(roomDto);
    }
    @PutMapping("/rooms/{id}")
    public RoomResponseDto updateRoomById(@PathVariable("id") int roomId, @RequestBody RoomDto roomDto) {
        return roomService.updateRoomById(roomId,roomDto);
    }
    @DeleteMapping("/rooms/{id}")
    public void deleteRoomById(@PathVariable("id") Integer roomId) {
        roomService.deleteRoomById(roomId);
    }
}
