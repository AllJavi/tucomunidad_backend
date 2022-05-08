package com.ISST18.tucomunidad.tucomunidad.service;

import java.util.ArrayList;

import com.ISST18.tucomunidad.tucomunidad.model.Reunion;
import com.ISST18.tucomunidad.tucomunidad.repository.ReunionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReunionService {
    @Autowired
    ReunionRepository reunionRepository;

    public ArrayList<Reunion> getAllReunion() {
        ArrayList<Reunion> instalaciones = new ArrayList<Reunion>();
        reunionRepository.findAll().forEach(instalacion -> instalaciones.add(instalacion));
        return instalaciones;
    }

    public Reunion getReunionById(Long id) {
        return reunionRepository.findById(id).get();
    }

    public void newReunion(Reunion reunion) {
        reunionRepository.save(reunion);
    }

    public void delete(Long id) {
        reunionRepository.deleteById(id);
    }

}
