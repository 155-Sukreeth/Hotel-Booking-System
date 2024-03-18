package com.finalproject.hotelbookingsystem.service;

import com.finalproject.hotelbookingsystem.dto.HotelDto;

import java.util.List;

public interface HotelService {

    HotelDto getHotelById(int id);

    List<HotelDto> getAllHotels();

    HotelDto createHotel(HotelDto hotelDto);

    HotelDto updateHotel( HotelDto hotelDto);

    String deleteHotel(int id);


}
