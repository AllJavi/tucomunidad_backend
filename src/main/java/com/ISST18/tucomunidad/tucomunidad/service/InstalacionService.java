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

    public void seedInstalacion() {
        ArrayList<Instalacion> Instalaciones = new ArrayList<Instalacion>();
        instalacionRepository.findAll().forEach(Instalacion -> Instalaciones.add(Instalacion));
        Instalacion piscina = new Instalacion(
                "piscina",
                "https://img.europapress.es/fotoweb/fotonoticia_20200704083334_420.jpg",
                800,
                2000,
                100,
                0,
                "1957");

        Instalacion padel = new Instalacion(
                "padel",
                "https://sportglobal.es/wp-content/uploads/2019/05/instalacion-pista-padel.jpg",
                1000,
                2200,
                50,
                5,
                "1957");
        
        instalacionRepository.save(piscina);
        instalacionRepository.save(padel);
    }

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
