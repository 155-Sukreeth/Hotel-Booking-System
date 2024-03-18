package com.finalproject.hotelbookingsystem.service;

import com.finalproject.hotelbookingsystem.dto.RoomDto;

import java.util.List;

public interface RoomService {

    RoomDto getRoomById(int room_id);
    List<RoomDto> getAllRooms();

    RoomDto deleteRoomById(int room_id);

    RoomDto updateRoomById(int room_id);

}

