package com.ISST18.tucomunidad.tucomunidad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ArrayList<String>> showAll() {
        ArrayList<String> comStr = new ArrayList<String>();
        for (Comunidad com : comunidadService.getAllComunidades()){
            comStr.add(com.toString());
        }
        return ResponseEntity.ok().body(comStr); 
    }
    
    @CrossOrigin
    @GetMapping("api/v1/comunidad/{comunityCode}")
    public ResponseEntity<String> findByComunityCode(@PathVariable String comunityCode) {
        Comunidad comunidad = comunidadService.findByComunityCode(comunityCode);

        if (comunidad == null){
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(comunidad.toString());
        
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/comunidad/register/{gestor}")
    public ResponseEntity<String> register(@RequestBody Comunidad comunidad, @PathVariable String gestor) {
        Comunidad newComunidad = new Comunidad(
        gestor,
        comunidad.getCalle(), 
        comunidad.getNumero(),
        comunidad.getCPostal(),
        comunidad.getComunityCode()
        );

        return ResponseEntity.ok().body(comunidadService.register(newComunidad));
    }


    @CrossOrigin
    @PostMapping(path = "api/v1/comunidad/{comunityCode}/post/delete")
    public ResponseEntity<Boolean> deletePost(@PathVariable String comunityCode, @RequestBody Long id) {
        Comunidad comunidad = comunidadService.findByComunityCode(comunityCode);
        comunidad.removePost(id);
        return ResponseEntity.ok().body(true);
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/comunidad/{comunityCode}/{parentPost}/post")
    public ResponseEntity<Boolean> newSubPost(@PathVariable String comunityCode, @PathVariable Long parentPost,
            @RequestBody Post post) {
        Comunidad comunidad = comunidadService.findByComunityCode(comunityCode);
        Post parent = comunidad.getPost(parentPost);
        parent.newSubPost(post);
        return ResponseEntity.ok().body(true);
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/comunidad/{comunityCode}/votacion")
    public ResponseEntity<Boolean> newVotacion(@PathVariable String comunityCode, @RequestBody Votacion votacion) {
        Comunidad comunidad = comunidadService.findByComunityCode(comunityCode);
        comunidad.addVotacion(votacion);
        return ResponseEntity.ok().body(true);
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/comunidad/{comunityCode}/votacion/delete")
    public ResponseEntity<Boolean> deleteVotacion(@PathVariable String comunityCode, @RequestBody Long id) {
        Comunidad comunidad = comunidadService.findByComunityCode(comunityCode);
        comunidad.removeVotacion(id);
        return ResponseEntity.ok().body(true);
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/comunidad/{comunityCode}/{idInstalacion}/")
    public ResponseEntity<Boolean> addReserva(@PathVariable String comunityCode, @PathVariable Long idInstalacion,
            @RequestBody Reserva reserva) {
        Comunidad comunidad = comunidadService.findByComunityCode(comunityCode);
        int instalacionIndex = comunidad.findByInstalacionId(idInstalacion);

        if (instalacionIndex == -1)
            return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);

        comunidad.getInstalaciones().get(instalacionIndex).addReserva(reserva);

        return ResponseEntity.ok().body(true);
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/comunidad/{comunityCode}/{idInstalacion}/delete")
    public ResponseEntity<Boolean> deleteReserva(@PathVariable String comunityCode, @PathVariable Long idInstalacion,
            @RequestBody Long id) {
        Comunidad comunidad = comunidadService.findByComunityCode(comunityCode);
        int instalacionIndex = comunidad.findByInstalacionId(idInstalacion);
        if (instalacionIndex == -1)
            return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
        comunidad.getInstalaciones().get(instalacionIndex).removeReserva(id);

        return ResponseEntity.ok().body(true);
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/comunidad/{comunityCode}/reunion")
    public ResponseEntity<Boolean> newReunion(@PathVariable String comunityCode, @RequestBody Reunion reunion) {
        Comunidad comunidad = comunidadService.findByComunityCode(comunityCode);
        comunidad.addReunion(reunion);
        return ResponseEntity.ok().body(true);
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/comunidad/{comunityCode}/reunion/delete")
    public ResponseEntity<Boolean> deleteReunion(@PathVariable String comunityCode, @RequestBody Long id) {
        Comunidad comunidad = comunidadService.findByComunityCode(comunityCode);
        comunidad.removeReunion(id);
        return ResponseEntity.ok().body(true);
    }

}
