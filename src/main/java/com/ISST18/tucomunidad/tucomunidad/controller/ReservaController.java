package com.ISST18.tucomunidad.tucomunidad.controller;

import java.util.ArrayList;

import com.ISST18.tucomunidad.tucomunidad.model.Reserva;
import com.ISST18.tucomunidad.tucomunidad.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ArrayList<String>> showAll() {
        ArrayList<String> resStr = new ArrayList<String>();
        for (Reserva res : votacionService.getAllReserva()){
            resStr.add(res.toString());
        }
        return ResponseEntity.ok().body(resStr); 
    }

    @CrossOrigin
    @GetMapping("api/v1/reserva/{id}")
    public ResponseEntity<String> getReservaById(@PathVariable Long id) {
        return ResponseEntity.ok().body(votacionService.getReservaById(id).toString());
    }

    @CrossOrigin
    @PostMapping("api/v1/reserva/")
    public void newReserva(@RequestBody Reserva reserva) {
        votacionService.newReserva(reserva);
    }
    @CrossOrigin
    @GetMapping("api/v1/reserva/delete/{id}")
    public void delete(@PathVariable Long id) {
        votacionService.delete(id);
    }
}