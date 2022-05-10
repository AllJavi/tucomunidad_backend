package com.ISST18.tucomunidad.tucomunidad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ISST18.tucomunidad.tucomunidad.model.Comunidad;
import com.ISST18.tucomunidad.tucomunidad.model.Post;
import com.ISST18.tucomunidad.tucomunidad.model.Reserva;
import com.ISST18.tucomunidad.tucomunidad.model.Reunion;
import com.ISST18.tucomunidad.tucomunidad.model.Votacion;
import com.ISST18.tucomunidad.tucomunidad.service.ComunidadService;


import java.util.ArrayList;

@RestController
public class ComunidadController {
    @Autowired
    ComunidadService comunidadService;
   
       
    @CrossOrigin
    @GetMapping("api/v1/comunidad/load")
    public void seedComunity(){
        comunidadService.seedComunity();
    }

    @CrossOrigin
    @GetMapping("api/v1/comunidad")
    @ResponseBody
    public ArrayList<Comunidad> showAll() {
        return comunidadService.getAllComunidades();
    }
    
    @CrossOrigin
    @GetMapping("api/v1/comunidad/{comunityCode}")
    public Comunidad findByComunityCode(@PathVariable String comunityCode) {
        return comunidadService.findByComunityCode(comunityCode);
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/comunidad/register/{gestor}")
    public String register(@RequestBody Comunidad comunidad, @PathVariable String gestor) {
        Comunidad newComunidad = new Comunidad(
        gestor,
        comunidad.getCalle(), 
        comunidad.getNumero(),
        comunidad.getCPostal(),
        comunidad.getComunityCode()
        );
        
        return comunidadService.register(newComunidad);
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/comunidad/{comunityCode}/post/delete")
    public boolean deletePost(@PathVariable String comunityCode, @RequestBody Long id) {
        Comunidad comunidad = findByComunityCode(comunityCode);
        comunidad.removePost(id);
        return true;
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/comunidad/{comunityCode}/{parentPost}/post")
    public boolean newSubPost(@PathVariable String comunityCode, @PathVariable Long parentPost,
            @RequestBody Post post) {
        Comunidad comunidad = findByComunityCode(comunityCode);
        Post parent = comunidad.getPost(parentPost);
        parent.newSubPost(post);
        return true;
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/comunidad/{comunityCode}/votacion")
    public boolean newVotacion(@PathVariable String comunityCode, @RequestBody Votacion votacion) {
        Comunidad comunidad = findByComunityCode(comunityCode);
        comunidad.addVotacion(votacion);
        return true;
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/comunidad/{comunityCode}/votacion/delete")
    public boolean deleteVotacion(@PathVariable String comunityCode, @RequestBody Long id) {
        Comunidad comunidad = findByComunityCode(comunityCode);
        comunidad.removeVotacion(id);
        return true;
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/comunidad/{comunityCode}/{idInstalacion}/")
    public boolean addReserva(@PathVariable String comunityCode, @PathVariable Long idInstalacion,
            @RequestBody Reserva reserva) {
        Comunidad comunidad = findByComunityCode(comunityCode);
        int instalacionIndex = comunidad.findByInstalacionId(idInstalacion);
        if (instalacionIndex == -1)
            return false;
        comunidad.getInstalaciones().get(instalacionIndex).addReserva(reserva);

        return true;
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/comunidad/{comunityCode}/{idInstalacion}/delete")
    public boolean deleteReserva(@PathVariable String comunityCode, @PathVariable Long idInstalacion,
            @RequestBody Long id) {
        Comunidad comunidad = findByComunityCode(comunityCode);
        int instalacionIndex = comunidad.findByInstalacionId(idInstalacion);
        if (instalacionIndex == -1)
            return false;
        comunidad.getInstalaciones().get(instalacionIndex).removeReserva(id);

        return true;
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/comunidad/{comunityCode}/reunion")
    public boolean newReunion(@PathVariable String comunityCode, @RequestBody Reunion reunion) {
        Comunidad comunidad = findByComunityCode(comunityCode);
        comunidad.addReunion(reunion);
        return true;
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/comunidad/{comunityCode}/reunion/delete")
    public boolean deleteReunion(@PathVariable String comunityCode, @RequestBody Long id) {
        Comunidad comunidad = findByComunityCode(comunityCode);
        comunidad.removeReunion(id);
        return true;
    }

}
