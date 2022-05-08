package com.ISST18.tucomunidad.tucomunidad.service;

import java.util.ArrayList;

import com.ISST18.tucomunidad.tucomunidad.model.Votacion;
import com.ISST18.tucomunidad.tucomunidad.repository.VotacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotacionService {
    @Autowired
    VotacionRepository votacionRepository;

    public ArrayList<Votacion> getAllVotacion() {
        ArrayList<Votacion> instalaciones = new ArrayList<Votacion>();
        votacionRepository.findAll().forEach(instalacion -> instalaciones.add(instalacion));
        return instalaciones;
    }

    public Votacion getVotacionById(Long id) {
        return votacionRepository.findById(id).get();
    }

    public void newVotacion(Votacion votacion) {
        votacionRepository.save(votacion);
    }

    public void delete(Long id) {
        votacionRepository.deleteById(id);
    }
}
