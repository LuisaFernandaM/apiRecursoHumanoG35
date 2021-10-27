package com.reto3.demo.service;


import java.util.List;
import java.util.Optional;
import com.reto3.demo.model.Reservation;
import com.reto3.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int reservationId) {
        return reservationRepository.getReservation(reservationId);
    }

    public Reservation save(Reservation rsvt) {
        if (rsvt.getIdReservation() == null) {
            return reservationRepository.save(rsvt);
        } else {
            Optional<Reservation> consulta = reservationRepository.getReservation(rsvt.getIdReservation());
            if (consulta.isEmpty()) {
                return reservationRepository.save(rsvt);
            } else {
                return rsvt;

            }
        }
    }

}
