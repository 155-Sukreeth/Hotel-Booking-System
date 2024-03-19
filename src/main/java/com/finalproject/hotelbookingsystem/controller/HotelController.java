package com.finalproject.hotelbookingsystem.controller;


import com.finalproject.hotelbookingsystem.dto.HotelDto;
import com.finalproject.hotelbookingsystem.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel-api/v1")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/hotels/{id}")
    public HotelDto getHotelById(@PathVariable("id") int id) {
        return hotelService.getHotelById(id);
    }

    @GetMapping
    public List<HotelDto> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @PostMapping(value = "/hotels")
    public ResponseEntity<HotelDto> createHotel(@RequestBody HotelDto hotelDto) {

        return new ResponseEntity<>(hotelService.createHotel(hotelDto), HttpStatus.CREATED);
    }

    @PutMapping("/hotels")
    public HotelDto updateHotel(@RequestBody HotelDto hotelDto) {
        return hotelService.updateHotel(hotelDto);
    }


    @DeleteMapping("/hotels/{id}")
    public String deleteHotel(@PathVariable("id") int id) {
        return hotelService.deleteHotel(id);

    }
}
