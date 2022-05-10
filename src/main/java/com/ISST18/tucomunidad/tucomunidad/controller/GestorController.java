package com.ISST18.tucomunidad.tucomunidad.controller;

import org.aspectj.lang.annotation.control.CodeGenerationHint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Objects;

import com.ISST18.tucomunidad.tucomunidad.model.Gestor;
import com.ISST18.tucomunidad.tucomunidad.service.GestorService;

@RestController
public class GestorController {
    @Autowired
    GestorService gestorService;

    @RequestMapping(path = "api/v1/gestor")
    @ResponseBody
    public ArrayList<Gestor> showAll() {
        return gestorService.getAllGestors();
    }
    
    @CrossOrigin
    @GetMapping(path = "api/v1/gestor/login")
    @ResponseBody
    public Gestor login(@RequestParam String email, @RequestParam String numAdmin, @RequestParam String password) {
       return gestorService.login(email, numAdmin, password); 
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/gestor/register")
    public boolean register(@RequestBody Gestor gestor) {
        return gestorService.register(gestor);
    }

    @GetMapping(path = "api/v1/gestor/load")
    public void seedGestor() {
        gestorService.seedGestores();
    }
    @CrossOrigin
    @GetMapping(path = "api/v1/gestor/{email}")
    public Gestor getGestorById(@PathVariable String email) {
        return gestorService.checkExist(email);
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/gestor/comunidad")
    public Gestor addComunidad(@RequestParam String email, @RequestParam String comunidad) {
        return gestorService.addComunidad(email, comunidad);
    }

}
