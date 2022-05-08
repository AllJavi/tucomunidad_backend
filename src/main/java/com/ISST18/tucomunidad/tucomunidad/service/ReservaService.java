package com.ISST18.tucomunidad.tucomunidad.service;

import java.util.ArrayList;

import com.ISST18.tucomunidad.tucomunidad.model.Reserva;
import com.ISST18.tucomunidad.tucomunidad.repository.ReservaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {
    @Autowired
    ReservaRepository reservaRepository;

    public ArrayList<Reserva> getAllReserva() {
        ArrayList<Reserva> reservaes = new ArrayList<Reserva>();
        reservaRepository.findAll().forEach(reserva -> reservaes.add(reserva));
        return reservaes;
    }

    public Reserva getReservaById(Long id) {
        return reservaRepository.findById(id).get();
    }

    public void newReserva(Reserva reserva) {
        reservaRepository.save(reserva);
    }

    public void delete(Long id) {
        reservaRepository.deleteById(id);
    }
}
