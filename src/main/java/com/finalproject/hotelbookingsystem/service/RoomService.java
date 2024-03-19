package com.finalproject.hotelbookingsystem.service;

import com.finalproject.hotelbookingsystem.dto.RoomDto;

import java.util.List;

public interface RoomService {

    RoomDto createRoom(RoomDto roomDto);
    RoomDto getRoomById(int roomId);
    List<RoomDto> getAllRooms();

    String deleteRoomById(int roomId);

    RoomDto updateRoomById(int roomId,RoomDto roomDto );

}

