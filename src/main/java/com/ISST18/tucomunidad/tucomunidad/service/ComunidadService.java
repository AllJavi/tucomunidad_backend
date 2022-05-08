package com.ISST18.tucomunidad.tucomunidad.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ISST18.tucomunidad.tucomunidad.model.Comunidad;
import com.ISST18.tucomunidad.tucomunidad.repository.ComunidadRepository;

@Service
public class ComunidadService {
    @Autowired
    ComunidadRepository comunidadRepository;

    public List<Comunidad> getAllComunidad() {
        List<Comunidad> Comunidades = new ArrayList<Comunidad>();
        comunidadRepository.findAll().forEach(Comunidad -> Comunidades.add(Comunidad));
        return Comunidades;
    }

    public Comunidad getComunidadById(long id) {
        return comunidadRepository.findById(id).get();
    }

    public void saveOrUpdate(Comunidad Comunidad) {
        comunidadRepository.save(Comunidad);
    }

    public void delete(long id) {
        comunidadRepository.deleteById(id);
    }
}
