package com.example.demo.controllers;

import com.example.demo.persistence.entities.Cabin;
import com.example.demo.services.CabinServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Cabin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class CabinController {

    @Autowired
    private CabinServiceImpl cabinService;

    @PostMapping(path="save")
    public ResponseEntity<Cabin> saveNewCabin(@RequestBody Cabin cabin){
        Cabin cabinSaved = cabinService.saveEntity(cabin);
        if(cabinSaved.getRooms() == null || cabinSaved.getBrand() == null){
            return new ResponseEntity<>(cabinSaved, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(cabinSaved, HttpStatus.CREATED);
    }

    @GetMapping(path = "all")
    public List<Cabin> getAllCabin(){
        return cabinService.getEntity();
    }
}
