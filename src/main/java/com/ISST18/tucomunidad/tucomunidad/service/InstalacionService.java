package com.ISST18.tucomunidad.tucomunidad.service;

import java.util.ArrayList;

import com.ISST18.tucomunidad.tucomunidad.model.Instalacion;
import com.ISST18.tucomunidad.tucomunidad.repository.InstalacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstalacionService {
    @Autowired
    InstalacionRepository instalacionRepository;

    public ArrayList<Instalacion> getAllInstalacion() {
        ArrayList<Instalacion> instalaciones = new ArrayList<Instalacion>();
        instalacionRepository.findAll().forEach(instalacion -> instalaciones.add(instalacion));
        return instalaciones;
    }

    public Instalacion getInstalacionById(Long id) {
        return instalacionRepository.findById(id).get();
    }

    public void newInstalacion(Instalacion instalacion) {
        instalacionRepository.save(instalacion);
    }

    public void delete(Long id) {
        instalacionRepository.deleteById(id);
    }
}
