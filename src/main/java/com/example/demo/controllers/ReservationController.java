package com.example.demo.controllers;

import com.example.demo.DTO.MessageDto;
import com.example.demo.persistence.entities.Reservation;
import com.example.demo.services.ReservationServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Reservation")
public class ReservationController {
    @Autowired
    ReservationServiceImpl reservationService;

    @Autowired
    ObjectMapper mapper;

    private static final Logger logger = LogManager.getLogger(MessageController.class);

    @PostMapping(path = "/save")
    public ResponseEntity<Reservation> saveReservation(@RequestBody Reservation reservation){
        Reservation reservation1 = reservationService.saveEntity(reservation);
        if(reservation1.getStatus() == null ){
            return new ResponseEntity<>(reservation1, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(reservation1, HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public List<Reservation> listReservation(){
        return reservationService.getEntity();
    }
}
