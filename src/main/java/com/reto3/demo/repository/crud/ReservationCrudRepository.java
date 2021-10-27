package com.reto3.demo.repository.crud;


import com.reto3.demo.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository <Reservation,Integer> {
    
}

