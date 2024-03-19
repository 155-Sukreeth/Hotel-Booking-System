package com.finalproject.hotelbookingsystem.service;

import com.finalproject.hotelbookingsystem.dto.HotelDto;
import com.finalproject.hotelbookingsystem.entity.HotelEntity;
import com.finalproject.hotelbookingsystem.exceptions.HotelIdNotFoundException;
import com.finalproject.hotelbookingsystem.repository.HotelRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {
    private static final Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);
    @Autowired
    private final HotelRepository hotelRepository;
    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public HotelDto getHotelById(int id) {
        logger.info("Fetching hotel by id: {}", id);
        Optional<HotelEntity> hotelOptional = hotelRepository.findById(id);
        if(hotelOptional.isEmpty()){
            logger.warn("Hotel not found with id: {}", id);
            throw new HotelIdNotFoundException("Hotel Id not found");
        }
        return modelMapper.map(hotelOptional.get(), HotelDto.class);
    }

    @Override
    public List<HotelDto> getAllHotels() {
        logger.info("Fetching all hotels");
        List<HotelDto> hotels = hotelRepository.findAll()
        .stream()
                .map(hotelEntity -> modelMapper.map(hotelEntity, HotelDto.class))
                .collect(Collectors.toList());
        return  hotels;
    }

    @Override
    public HotelDto createHotel(HotelDto hotelDto) {
        logger.info("Creating hotel: {}", hotelDto);
        HotelEntity savedHotelEntity = hotelRepository.save(modelMapper.map(hotelDto, HotelEntity.class));
        return modelMapper.map(savedHotelEntity, HotelDto.class);
    }


    @Override
    public HotelDto updateHotelById(int id, HotelDto updatedHotelDto) {
        logger.info("Creating hotel: {}", updatedHotelDto);
        Optional<HotelEntity> optionalHotel = hotelRepository.findById(id);
        if (optionalHotel.isEmpty()) {
            logger.warn("Hotel not found with id: {}", id);
            throw new HotelIdNotFoundException("Hotel not found with id: " + id);
        }

        HotelEntity existingHotel = optionalHotel.get();
        existingHotel.setName(updatedHotelDto.getName());
        existingHotel.setAddress(updatedHotelDto.getAddress());

        HotelEntity updatedHotelEntity = hotelRepository.save(existingHotel);
        return modelMapper.map(updatedHotelEntity, HotelDto.class);
    }


    @Override
    public String deleteHotel(int id) {
        logger.info("Deleting hotel with id: {}", id);
       boolean result = hotelRepository.existsById(id);
        if (result) {
            hotelRepository.deleteById(id);
            return "hotel with hotel id "+" "+"deleted successfully";
        } else {
            return "product with product id"+" "+"does not exits in db";
        }
    }
}
