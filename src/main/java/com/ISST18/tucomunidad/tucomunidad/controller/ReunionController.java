package com.ISST18.tucomunidad.tucomunidad.controller;

import java.util.ArrayList;

import com.ISST18.tucomunidad.tucomunidad.model.Reunion;
import com.ISST18.tucomunidad.tucomunidad.service.ReunionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReunionController {
    @Autowired
    ReunionService votacionService;

    @CrossOrigin
    @GetMapping("api/v1/reunion")
    public ResponseEntity<ArrayList<String>> showAll() {
        ArrayList<String> reunionStr = new ArrayList<String>();
        for (Reunion reunion : votacionService.getAllReunion()){
            reunionStr.add(reunion.toString());
        }
        return ResponseEntity.ok().body(reunionStr); 
    }

    @CrossOrigin
    @GetMapping("reunion/{id}")
    public ResponseEntity<String> getReunionById(@PathVariable Long id) {
        return ResponseEntity.ok().body(votacionService.getReunionById(id).toString());
    }

    @CrossOrigin
    @PostMapping("api/v1/reunion/")
    public void newReunion(@RequestBody Reunion reunion) {
        votacionService.newReunion(reunion);
    }

    @CrossOrigin
    @GetMapping("api/v1/reunion/delete/{id}")
    public void delete(@PathVariable Long id) {
        votacionService.delete(id);
    }
}