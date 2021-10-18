package com.example.demo.services;

import com.example.demo.persistence.entities.Cabin;
import com.example.demo.persistence.entities.Client;
import com.example.demo.persistence.entities.Reservation;
import com.example.demo.persistence.repository.CabinRepository;
import com.example.demo.persistence.repository.ClientRepository;
import com.example.demo.persistence.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservationServiceImpl implements EntityService<Reservation>{
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CabinRepository cabinRepository;


    @Override
    public Reservation saveEntity(Reservation entity) {
        Date currentDate = new Date();
        Client client = clientRepository.findById(entity.getClient().getIdClient()).get();
        Cabin cabin = cabinRepository.findById(entity.getCabin().getId()).get();
        entity.setStatus("created");
        entity.setCreatedDate(currentDate);
        entity.setCabin(cabin);
        entity.setClient(client);
        return reservationRepository.save(entity);
    }

    @Override
    public List<Reservation> getEntity() {
        return reservationRepository.findAll();
    }
}
