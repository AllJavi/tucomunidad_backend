package com.ISST18.tucomunidad.tucomunidad.controller;

import java.util.ArrayList;

import com.ISST18.tucomunidad.tucomunidad.model.Instalacion;
import com.ISST18.tucomunidad.tucomunidad.service.InstalacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstalacionController {
    @Autowired
    InstalacionService instalacionService;

    @CrossOrigin
    @GetMapping("api/v1/instalacion")
    public ArrayList<Instalacion> getAllInstalacion() {
        return instalacionService.getAllInstalacion();
    }

    @CrossOrigin
    @GetMapping("api/v1/instalacion/{id}")
    public Instalacion getInstalacionById(@PathVariable Long id) {
        return instalacionService.getInstalacionById(id);
    }

    @CrossOrigin
    @PostMapping("api/v1/instalacion/")
    public void newInstalacion(@RequestBody Instalacion instalacion) {
        instalacionService.newInstalacion(instalacion);
    }

    @CrossOrigin
    @GetMapping("api/v1/instalacion/delete/{id}")
    public void delete(@PathVariable Long id) {
        instalacionService.delete(id);
    }

    @GetMapping("api/v1/instalacion/load")
    public void seedInstalacion(){
        instalacionService.seedInstalacion();
    }
}