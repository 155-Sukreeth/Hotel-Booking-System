package com.finalproject.hotelbookingsystem.service;

import com.finalproject.hotelbookingsystem.dto.RoomDto;

import java.util.List;

public interface RoomService {

    RoomDto createRoom(RoomDto roomDto);
    RoomDto getRoomById(int room_id);
    List<RoomDto> getAllRooms();

    String deleteRoomById(int room_id);

    RoomDto updateRoomById(RoomDto roomDto );

}

