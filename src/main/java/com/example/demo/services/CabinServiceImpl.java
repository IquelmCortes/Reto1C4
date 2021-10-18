package com.example.demo.services;

import com.example.demo.persistence.entities.Cabin;
import com.example.demo.persistence.entities.Category;
import com.example.demo.persistence.entities.Message;
import com.example.demo.persistence.entities.Reservation;
import com.example.demo.persistence.repository.CabinRepository;
import com.example.demo.persistence.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CabinServiceImpl implements EntityService<Cabin>{

    @Autowired
    CabinRepository cabinRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Cabin saveEntity(Cabin cabin) {
        boolean cumple = cabin.getBrand().length() <= 45 && cabin.getName().length()<= 45 && cabin.getRooms()>=0 &&
                cabin.getRooms()<=15 && cabin.getDescription().length() <= 250;
        Category category = cabin.getCategory() == null? new Category(): cabin.getCategory().getId() == null?
                new Category():categoryRepository.findById(cabin.getCategory().getId()).get();
        List<Message> messages = new ArrayList<Message>();
        List<Reservation> reservations = new ArrayList<Reservation>();
        cabin.setCategory(category);

        if(cumple){
            Cabin cabin1 = cabinRepository.save(cabin);
            return cabin1;
        }

        return new Cabin(null,null, null, null, null,null, null);
    }

    @Override
    public List<Cabin> getEntity() {
        return cabinRepository.findAll();
    }
}
