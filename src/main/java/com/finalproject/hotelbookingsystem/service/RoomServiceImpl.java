package com.finalproject.hotelbookingsystem.service;

import com.finalproject.hotelbookingsystem.controller.RoomController;
import com.finalproject.hotelbookingsystem.dto.RoomDto;
import com.finalproject.hotelbookingsystem.entity.RoomEntity;
import com.finalproject.hotelbookingsystem.repository.RoomRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService{

    private static final Logger logger= LoggerFactory.getLogger(RoomServiceImpl.class);

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ModelMapper modelmapper;
    @Override
    public RoomDto createRoom(RoomDto roomDto) {
        RoomEntity roomEntity=roomRepository.save(modelmapper.map(roomDto,RoomEntity.class));
        logger.info("Room is created successfully");
        return modelmapper.map(roomEntity,RoomDto.class);
    }

    @Override
    public RoomDto getRoomById(int roomId) {

        Optional<RoomEntity> roomEntityOptional= roomRepository.findById(roomId);
        if(roomEntityOptional.isEmpty())
        {

            logger.warn("Room ID does not found");
        }
        return modelmapper.map(roomEntityOptional.get(),RoomDto.class);
    }

    @Override
    public List<RoomDto> getAllRooms() {

        List<RoomDto> roomDtoList=roomRepository.findAll()
                .stream().map(e->modelmapper.map(e,RoomDto.class))
                .collect(Collectors.toList());
        return roomDtoList;
    }

    @Override
    public String deleteRoomById(int roomId) {

        boolean isthere=roomRepository.existsById(roomId);
        if(isthere)
        {
            roomRepository.deleteById(roomId);
            logger.info("Room is deleted successfully");
            return  "Room deleted successfully";
        }
        logger.warn("Room ID does not exist");
        return "room ID does not exist";
    }

    @Override
    public RoomDto updateRoomById(RoomDto roomDto) {

        RoomEntity roomEntity=roomRepository.save(modelmapper.map(roomDto,RoomEntity.class));
        logger.info("Room is updated successfully");
        return modelmapper.map(roomEntity,RoomDto.class);

    }
}




