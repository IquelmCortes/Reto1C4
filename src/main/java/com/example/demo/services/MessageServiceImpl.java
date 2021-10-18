package com.example.demo.services;

import com.example.demo.persistence.entities.Cabin;
import com.example.demo.persistence.entities.Client;
import com.example.demo.persistence.entities.Message;
import com.example.demo.persistence.repository.CabinRepository;
import com.example.demo.persistence.repository.ClientRepository;
import com.example.demo.persistence.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements EntityService<Message>{

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CabinRepository cabinRepository;


    @Override
    public Message saveEntity(Message entity) {
        boolean cumple = entity.getMessageText().length()<= 250;
        /*
        Client client = clientRepository.findById(entity.getClient().getIdClient()).get();
        Cabin cabin = cabinRepository.findById(entity.getCabin().getId()).get();
        entity.setCabin(cabin);
        entity.setClient(client);

         */
        if(cumple){
            return messageRepository.save(entity);
        }
        return new Message(null, null, null);
    }

    @Override
    public List<Message> getEntity() {
        return messageRepository.findAll();
    }
}
