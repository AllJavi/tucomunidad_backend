package com.ISST18.tucomunidad.tucomunidad.controller;

import java.util.ArrayList;

import com.ISST18.tucomunidad.tucomunidad.model.Votacion;
import com.ISST18.tucomunidad.tucomunidad.service.VotacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ArrayList<String>> showAll() {
        ArrayList<String> votStr = new ArrayList<String>();
        for (Votacion vot : votacionService.getAllVotacion()){
            votStr.add(vot.toString());
        }
        return ResponseEntity.ok().body(votStr); 
    }

    @CrossOrigin
    @GetMapping("api/v1/votacion/{id}")
    public ResponseEntity<String> getVotacionById(@PathVariable Long id) {
        return ResponseEntity.ok().body(votacionService.getVotacionById(id).toString());
    }

    @CrossOrigin
    @PostMapping("api/v1/votacion/")
    public void newVotacion(@RequestBody Votacion votacion) {
        votacionService.newVotacion(votacion);
    }

    @CrossOrigin
    @PostMapping("api/v1/votacion/delete/{id}")
    public void delete(@PathVariable Long id) {
        votacionService.delete(id);
    }
}
