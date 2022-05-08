package com.ISST18.tucomunidad.tucomunidad.controller;

import java.util.ArrayList;

import com.ISST18.tucomunidad.tucomunidad.model.Reunion;
import com.ISST18.tucomunidad.tucomunidad.service.ReunionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReunionController {
    @Autowired
    ReunionService votacionService;

    public ArrayList<Reunion> getAllReunion() {
        return votacionService.getAllReunion();
    }

    @CrossOrigin
    @GetMapping("post/{id}")
    public Reunion getReunionById(@PathVariable Long id) {
        return votacionService.getReunionById(id);
    }

    @CrossOrigin
    @PostMapping("api/v1/post/")
    public void newReunion(Reunion reunion) {
        votacionService.newReunion(reunion);
    }

    @CrossOrigin
    @GetMapping("api/v1/post/delete/{id}")
    public void delete(@PathVariable Long id) {
        votacionService.delete(id);
    }
}