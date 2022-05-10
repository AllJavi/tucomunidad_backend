package com.ISST18.tucomunidad.tucomunidad.controller;

import java.util.ArrayList;

import com.ISST18.tucomunidad.tucomunidad.model.Votacion;
import com.ISST18.tucomunidad.tucomunidad.service.VotacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VotacionController {
    @Autowired
    VotacionService votacionService;

    @CrossOrigin
    @GetMapping("api/v1/votacion")
    public ArrayList<Votacion> getAllVotacion() {
        return votacionService.getAllVotacion();
    }

    @CrossOrigin
    @GetMapping("api/v1/votacion/{id}")
    public Votacion getVotacionById(@PathVariable Long id) {
        return votacionService.getVotacionById(id);
    }

    @CrossOrigin
    @PostMapping("api/v1/votacion/")
    public void newVotacion(@RequestBody Votacion votacion) {
        System.out.println(votacion.getOpcionA());
        System.out.println(votacion.getOpcionB());
        votacionService.newVotacion(votacion);
    }

    @CrossOrigin
    @PostMapping("api/v1/votacion/delete/{id}")
    public void delete(@PathVariable Long id) {
        votacionService.delete(id);
    }
}
