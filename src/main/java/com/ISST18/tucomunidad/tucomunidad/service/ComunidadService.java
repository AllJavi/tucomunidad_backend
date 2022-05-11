package com.ISST18.tucomunidad.tucomunidad.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ISST18.tucomunidad.tucomunidad.model.Comunidad;
import com.ISST18.tucomunidad.tucomunidad.repository.ComunidadRepository;

@Service
public class ComunidadService {
    @Autowired
    ComunidadRepository comunidadRepository;

    public void seedComunity() {
        ArrayList<Comunidad> Comunidades = new ArrayList<Comunidad>();
        comunidadRepository.findAll().forEach(Comunidad -> Comunidades.add(Comunidad));
        Comunidad c1 = new Comunidad(
                "000000",
                "Av. Complutense",
                30,
                "28040",
                "1957");
        Comunidad c2 = new Comunidad(
                "000000",
                "Av. Castellana",
                31,
                "28040",
                "1958");
        Comunidad c3 = new Comunidad(
                "000000",
                "C. Ratones",
                32,
                "28040",
                "1959");
        comunidadRepository.save(c1);
        comunidadRepository.save(c2);
        comunidadRepository.save(c3);
    }

    public ArrayList<Comunidad> getAllComunidades() {
        ArrayList<Comunidad> Comunidades = new ArrayList<Comunidad>();
        comunidadRepository.findAll().forEach(Comunidad -> Comunidades.add(Comunidad));
        return Comunidades;
    }

    public Comunidad getComunidadById(Long id) {
        return comunidadRepository.findById(id).get();
    }

    public void delete(Long id) {
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

        if (findByComunityCode(comunidad.getComunityCode()) != null) {
            return "Código de comunidad ya existente";
        }
        comunidadRepository.save(comunidad);
        return "Comunidad registrada con éxito";
    }

    public Comunidad info(String comunityCode) {
        return findByComunityCode(comunityCode);
    }

}
