package com.example.demo.services;

import com.example.demo.persistence.entities.Client;
import com.example.demo.persistence.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements EntityService<Client>{

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Client saveEntity(Client entity) {
        boolean cumple = entity.getPassword().length() <=45 && entity.getEmail().length()<=45&&
                entity.getAge()<=130 && entity.getAge()>=0 && entity.getName().length()<=250;
        if(cumple){
            return clientRepository.save(entity);
        }
        return new Client(null, null,null,null);
    }

    @Override
    public List<Client> getEntity() {
        return clientRepository.findAll();
    }
}
