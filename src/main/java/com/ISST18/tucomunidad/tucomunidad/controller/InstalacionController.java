package com.ISST18.tucomunidad.tucomunidad.controller;

import java.util.ArrayList;

import com.ISST18.tucomunidad.tucomunidad.model.Instalacion;
import com.ISST18.tucomunidad.tucomunidad.service.InstalacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstalacionController {
    @Autowired
    InstalacionService votacionService;

    public ArrayList<Instalacion> getAllInstalacion() {
        return votacionService.getAllInstalacion();
    }

    public Instalacion getInstalacionById(Long id) {
        return votacionService.getInstalacionById(id);
    }

    public void newInstalacion(Instalacion instalacion) {
        votacionService.newInstalacion(instalacion);
    }

    public void delete(Long id) {
        votacionService.delete(id);
    }
}