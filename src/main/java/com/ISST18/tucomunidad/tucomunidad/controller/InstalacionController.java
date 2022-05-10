package com.ISST18.tucomunidad.tucomunidad.controller;

import java.util.ArrayList;

import com.ISST18.tucomunidad.tucomunidad.model.Instalacion;
import com.ISST18.tucomunidad.tucomunidad.service.InstalacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ArrayList<String>> showAll() {
        ArrayList<String> instStr = new ArrayList<String>();
        for (Instalacion inst : instalacionService.getAllInstalacion()){
            instStr.add(inst.toString());
        }
        return ResponseEntity.ok().body(instStr); 
    }
    
    @CrossOrigin
    @GetMapping("api/v1/instalacion/{id}")
    public ResponseEntity<String> getInstalacionById(@PathVariable Long id) {
        Instalacion instalacion = instalacionService.getInstalacionById(id);
        if (instalacion == null){
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(instalacion.toString());
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