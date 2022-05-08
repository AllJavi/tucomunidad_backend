package com.ISST18.tucomunidad.tucomunidad.controller;

import java.util.ArrayList;

import com.ISST18.tucomunidad.tucomunidad.model.Votacion;
import com.ISST18.tucomunidad.tucomunidad.service.VotacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VotacionController {
    @Autowired
    VotacionService votacionService;

    public ArrayList<Votacion> getAllVotacion() {
        return votacionService.getAllVotacion();
    }

    public Votacion getVotacionById(Long id) {
        return votacionService.getVotacionById(id);
    }

    public void newVotacion(Votacion votacion) {
        votacionService.newVotacion(votacion);
    }

    public void delete(Long id) {
        votacionService.delete(id);
    }
}
