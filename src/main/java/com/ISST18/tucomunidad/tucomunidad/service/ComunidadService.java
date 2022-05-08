package com.ISST18.tucomunidad.tucomunidad.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ISST18.tucomunidad.tucomunidad.model.Comunidad;
import com.ISST18.tucomunidad.tucomunidad.model.Post;
import com.ISST18.tucomunidad.tucomunidad.repository.ComunidadRepository;

@Service
public class ComunidadService {
    @Autowired
    ComunidadRepository comunidadRepository;

    public ArrayList<Comunidad> getAllComunidades() {
        ArrayList<Comunidad> Comunidades = new ArrayList<Comunidad>();
        comunidadRepository.findAll().forEach(Comunidad -> Comunidades.add(Comunidad));
        return Comunidades;
    }

    public Comunidad getComunidadById(long id) {
        return comunidadRepository.findById(id).get();
    }

    public void delete(long id) {
        comunidadRepository.deleteById(id);
    }


    public Comunidad findByComunityCode(String comunityCode) {
        ArrayList<Comunidad> comunidades = getAllComunidades();
        for (Comunidad comunidad : comunidades)
            if (comunidad.getComunityCode().compareTo(comunityCode) == 0)
                return comunidad;
        return null;
    }

    
    public String register(Comunidad comunidad) {
                
        if(findByComunityCode(comunidad.getComunityCode()) != null) {
            return "Código de comunidad ya existente";
        }
        comunidadRepository.save(comunidad);
        return "Comunidad registrada con éxito";
    }

    
    public Comunidad info(String comunityCode) {
        return findByComunityCode(comunityCode);
    }

    public Comunidad newPost(String comunityCode, Post post) {
        Comunidad comunidad = findByComunityCode(comunityCode);
        comunidad.addPosts(post);
        comunidadRepository.deleteById(comunidad.getid());
        comunidadRepository.save(comunidad);
        return comunidad;
    }

 
    // public boolean addReserva(@PathVariable String comunityCode, @PathVariable Long idInstalacion,
    //         @RequestBody Reserva reserva) {
    //     Comunidad comunidad = findByComunityCode(comunityCode);
    //     int instalacionIndex = comunidad.findByInstalacionId(idInstalacion);
    //     if (instalacionIndex == -1)
    //         return false;
    //     comunidad.getInstalaciones().get(instalacionIndex).addReserva(reserva);

    //     return true;
    // }

    // public boolean deleteReserva(@PathVariable String comunityCode, @PathVariable Long idInstalacion,
    //         @RequestBody Long id) {
    //     Comunidad comunidad = findByComunityCode(comunityCode);
    //     int instalacionIndex = comunidad.findByInstalacionId(idInstalacion);
    //     if (instalacionIndex == -1)
    //         return false;
    //     comunidad.getInstalaciones().get(instalacionIndex).removeReserva(id);

    //     return true;
    // }

    // public boolean newReunion(@PathVariable String comunityCode, @RequestBody Reunion reunion) {
    //     Comunidad comunidad = findByComunityCode(comunityCode);
    //     comunidad.addReunion(reunion);
    //     return true;
    // }

    // public boolean deleteReunion(@PathVariable String comunityCode, @RequestBody Long id) {
    //     Comunidad comunidad = findByComunityCode(comunityCode);
    //     comunidad.removeReunion(id);
    //     return true;
    // }
}
