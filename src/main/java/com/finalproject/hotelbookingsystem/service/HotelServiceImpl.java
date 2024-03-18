package com.finalproject.hotelbookingsystem.service;

import com.finalproject.hotelbookingsystem.dto.HotelDto;
import com.finalproject.hotelbookingsystem.entity.HotelEntity;
import com.finalproject.hotelbookingsystem.repository.HotelRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {
    @Autowired
    private final HotelRepository hotelRepository;
    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public HotelDto getHotelById(int id) {
        Optional<HotelEntity> hotelOptional = hotelRepository.findById(id);
        if(hotelOptional.isEmpty()){
            throw new RuntimeException();
        }
        return modelMapper.map(hotelOptional.get(), HotelDto.class);
    }

    @Override
    public List<HotelDto> getAllHotels() {
        List<HotelDto> hotels = hotelRepository.findAll()
        .stream()
                .map(hotelEntity -> modelMapper.map(hotelEntity, HotelDto.class))
                .collect(Collectors.toList());
        return  hotels;
    }

    @Override
    public HotelDto createHotel(HotelDto hotelDto) {

        HotelEntity savedHotelEntity = hotelRepository.save(modelMapper.map(hotelDto, HotelEntity.class));
        return modelMapper.map(savedHotelEntity, HotelDto.class);
    }


    @Override
    public HotelDto updateHotel(HotelDto hotelDto) {
        HotelEntity hotelEntity =hotelRepository.save(modelMapper.map(hotelDto, HotelEntity.class));
        return modelMapper.map(hotelEntity, HotelDto.class);
    }


    @Override
    public String deleteHotel(int id) {
       boolean result = hotelRepository.existsById(id);
        if (result) {
            hotelRepository.deleteById(id);
            return "hotel with hotel id "+" "+"deleted successfully";
        } else {
            return "product with product id"+" "+"does not exits in db";
        }
    }
}
