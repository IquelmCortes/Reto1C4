package com.example.demo.controllers;

import com.example.demo.persistence.entities.Message;
import com.example.demo.services.MessageServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Message")
public class MessageController {

    @Autowired
    MessageServiceImpl messageService;

    private static final Logger logger = LogManager.getLogger(MessageController.class);

    @PostMapping(path = "/save")
    public ResponseEntity<Message> saveMessage(@RequestBody Message message){
        Message message1 = messageService.saveEntity(message);
        if(message1.getMessageText() == null ){
            return new ResponseEntity<>(message1, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(message1, HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public List<Message> listMessages(){
        return messageService.getEntity();
    }
}
