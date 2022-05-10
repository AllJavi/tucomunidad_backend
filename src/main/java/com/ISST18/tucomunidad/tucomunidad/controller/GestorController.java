package com.ISST18.tucomunidad.tucomunidad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<ArrayList<String>> showAll() {
        ArrayList<String> gestStr = new ArrayList<String>();
        for (Gestor gest : gestorService.getAllGestors()){
            gestStr.add(gest.toString());
        }
        return ResponseEntity.ok().body(gestStr); 
    }


    @CrossOrigin
    @GetMapping(path = "api/v1/gestor/login")
    @ResponseBody
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String numAdmin,
            @RequestParam String password) throws Exception {
        Gestor gestor = gestorService.login(email, numAdmin, password);
        if (gestor == null) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        
        return ResponseEntity.ok().body(gestor.toString2());
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/gestor/register")
    public ResponseEntity<Boolean> register(@RequestBody Gestor gestor) {
        return ResponseEntity.ok().body(gestorService.register(gestor));
    }

    @GetMapping(path = "api/v1/gestor/load")
    public void seedGestor() {
        gestorService.seedGestores();
    }

    @CrossOrigin
    @GetMapping(path = "api/v1/gestor/{email}")
    public ResponseEntity<String> getGestorById(@PathVariable String email) {
        Gestor gestor = gestorService.checkExist(email);
        if (gestor == null) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(gestor.toString2());
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/gestor/comunidad")
    public ResponseEntity<String> addComunidad(@RequestParam String email, @RequestParam String comunidad) {
        Gestor gestor = gestorService.addComunidad(email, comunidad);
        return ResponseEntity.ok().body(gestor.toString2());

    }

}
