package com.ISST18.tucomunidad.tucomunidad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import net.minidev.json.JSONObject;

import java.util.ArrayList;


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
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String numAdmin,
            @RequestParam String password) {
        Gestor gestor = gestorService.login(email, numAdmin, password);
        System.out.println(gestor.getNumAdmin());
        
        String gestorStr;
        JSONObject json = new JSONObject();
        json.put("nombre", gestor.getNombre());
        json.put("apellidos", gestor.getApellidos());
        json.put("email", gestor.getEmail());
        json.put("password", gestor.getPassword());
        json.put("numAdmin", gestor.getNumAdmin());
        json.put("comunidades", gestor.getComunidades());

        gestorStr = json.toString();
        return ResponseEntity.ok().body(gestorStr);
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
    public ResponseEntity<String> getGestorById(@PathVariable String email) {
        Gestor gestor = gestorService.findByEmail(email);
        if(gestor == null) {
            return ResponseEntity.status(404).build();
        }
        String gestorStr;
        JSONObject json = new JSONObject();
        json.put("nombre", gestor.getNombre());
        json.put("apellidos", gestor.getApellidos());
        json.put("email", gestor.getEmail());
        json.put("password", gestor.getPassword());
        json.put("numAdmin", gestor.getNumAdmin());
        json.put("comunidades", gestor.getComunidades());

        gestorStr = json.toString();
        return ResponseEntity.ok().body(gestorStr);
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/gestor/comunidad")
    public Gestor addComunidad(@RequestParam String email, @RequestParam String comunidad) {
        return gestorService.addComunidad(email, comunidad);
    }

}
