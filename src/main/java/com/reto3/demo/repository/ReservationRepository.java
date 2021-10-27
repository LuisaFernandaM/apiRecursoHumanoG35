package com.reto3.demo.repository;


import java.util.List;
import java.util.Optional;
import com.reto3.demo.model.Reservation;
import com.reto3.demo.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class ReservationRepository {
    
    @Autowired
    ReservationCrudRepository reservationCrudRepository;
    
    public List<Reservation>getAll(){
        return (List<Reservation>)reservationCrudRepository.findAll();
        
    }

    public Optional<Reservation>getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    
    public Reservation save (Reservation rsvt){
        return reservationCrudRepository.save(rsvt);
    }
}
