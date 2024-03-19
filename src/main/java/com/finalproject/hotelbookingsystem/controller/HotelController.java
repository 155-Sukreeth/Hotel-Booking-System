package com.finalproject.hotelbookingsystem.controller;


import com.finalproject.hotelbookingsystem.dto.HotelDto;
import com.finalproject.hotelbookingsystem.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel-api/v1")
public class HotelController {
    private static final Logger logger = LoggerFactory.getLogger(HotelController.class);
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/hotels/{id}")
    public HotelDto getHotelById(@PathVariable("id") int id) {
        logger.info("Fetching hotel by id: {}", id);
        return hotelService.getHotelById(id);
    }

    @GetMapping("/hotels")
    public List<HotelDto> getAllHotels() {
        logger.info("Fetching all hotels");
        return hotelService.getAllHotels();
    }

    @PostMapping(value = "/hotels")
    public ResponseEntity<HotelDto> createHotel(@RequestBody HotelDto hotelDto) {
        logger.info("Creating hotel: {}", hotelDto);

        return new ResponseEntity<>(hotelService.createHotel(hotelDto), HttpStatus.CREATED);
    }

    @PutMapping("/hotels/{id}")
    public ResponseEntity<HotelDto> updateHotelById(@PathVariable int id, @RequestBody HotelDto updatedHotelDto) {
        logger.info("Updating hotel with id {}: {}", id, updatedHotelDto);
        HotelDto updatedHotel = hotelService.updateHotelById(id, updatedHotelDto);
        return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
    }


    @DeleteMapping("/hotels/{id}")
    public String deleteHotel(@PathVariable("id") int id) {
        logger.info("Deleting hotel with id: {}", id);
        return hotelService.deleteHotel(id);

    }
}
