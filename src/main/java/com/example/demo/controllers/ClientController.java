package com.example.demo.controllers;

import com.example.demo.persistence.entities.Client;
import com.example.demo.services.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Client")
public class ClientController {

    @Autowired
    ClientServiceImpl clientService;

    @PostMapping(path="save")
    public ResponseEntity<Client> saveClient(@RequestBody Client client){
        Client client1 = clientService.saveEntity(client);
        if (client1.getName()==null && client1.getPassword()==null){
            return new ResponseEntity<>(client1, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(client1, HttpStatus.CREATED);
    }

    @GetMapping(path = "all")
    public List<Client> listClients(){
        return clientService.getEntity();
    }
}
