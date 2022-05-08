package com.ISST18.tucomunidad.tucomunidad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ISST18.tucomunidad.tucomunidad.model.Comunidad;
import com.ISST18.tucomunidad.tucomunidad.model.Instalacion;
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
   
    private ArrayList<Comunidad> comunidades;

    public ComunidadController() {
        this.comunidades = new ArrayList<>();
        Comunidad c1 = new Comunidad(
                "000000",
                "Av. Complutense",
                30,
                "28040",
                "1957");

        Instalacion piscina = new Instalacion(
                "piscina",
                "https://img.europapress.es/fotoweb/fotonoticia_20200704083334_420.jpg",
                800,
                2000,
                100,
                0,
                "1957");
        c1.addInstalacion(piscina);

        Instalacion padel = new Instalacion(
                "padel",
                "https://sportglobal.es/wp-content/uploads/2019/05/instalacion-pista-padel.jpg",
                1000,
                2200,
                50,
                5,
                "1957");
        c1.addInstalacion(padel);

        this.comunidades.add(c1);

    }
    @RequestMapping(path = "api/v1/comunidad")
    @ResponseBody
    public ArrayList<Comunidad> showAll() {
        return comunidadService.getAllComunidades();
    }
    
    @GetMapping("api/v1/comunidad/{comunityCode}")
    public Comunidad findByComunityCode(@PathVariable String comunityCode) {
        return comunidadService.findByComunityCode(comunityCode);
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/comunidad/register")
    public String register(@RequestBody Comunidad comunidad) {
        return comunidadService.register(comunidad);
    }

    @CrossOrigin
    @RequestMapping(path = "api/v1/comunidad/{comunityCode}")
    @ResponseBody
    public Comunidad info(@PathVariable String comunityCode) {
        return findByComunityCode(comunityCode);
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
