package com.ISST18.tucomunidad.tucomunidad.controller;

import java.util.ArrayList;

import com.ISST18.tucomunidad.tucomunidad.model.Reserva;
import com.ISST18.tucomunidad.tucomunidad.service.ReservaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservaController {
    @Autowired
    ReservaService votacionService;

    public ArrayList<Reserva> getAllReserva() {
        return votacionService.getAllReserva();
    }

    public Reserva getReservaById(Long id) {
        return votacionService.getReservaById(id);
    }

    public void newReserva(Reserva reserva) {
        votacionService.newReserva(reserva);
    }

    public void delete(Long id) {
        votacionService.delete(id);
    }
}