package com.ISST18.tucomunidad.tucomunidad.controller;

import java.util.ArrayList;

import com.ISST18.tucomunidad.tucomunidad.model.Reserva;
import com.ISST18.tucomunidad.tucomunidad.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservaController {
    @Autowired
    ReservaService votacionService;

    @CrossOrigin
    @GetMapping("api/v1/reserva")
    public ArrayList<Reserva> getAllReserva() {
        return votacionService.getAllReserva();
    }

    @CrossOrigin
    @GetMapping("api/v1/reserva/{id}")
    public Reserva getReservaById(@PathVariable Long id) {
        return votacionService.getReservaById(id);
    }

    @CrossOrigin
    @PostMapping("api/v1/reserva/")
    public Boolean newReserva(@RequestBody Reserva reserva) {
        return votacionService.newReserva(reserva);
    }
    @CrossOrigin
    @GetMapping("api/v1/reserva/delete/{id}")
    public void delete(@PathVariable Long id) {
        votacionService.delete(id);
    }

    @CrossOrigin
    @GetMapping("api/v1/reserva/{horaInicio}")
    public Reserva getReservaByHoraInicio(int horaInicio) {
        ArrayList<Reserva> reservas = getAllReserva();
        for (Reserva r : reservas) {
            if(r.getHoraInicio() == horaInicio){
                return r;
            }
        }
        return null;
    }

   
}