package com.ISST18.tucomunidad.tucomunidad.service;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ISST18.tucomunidad.tucomunidad.model.Gestor;
import com.ISST18.tucomunidad.tucomunidad.repository.GestorRepository;

@Service
public class GestorService {
    @Autowired
    GestorRepository gestorRepository;
   
    public void seedGestores() {
        
        Gestor u1 = new Gestor(
            "Ivan", 
            "Perez Broskis", 
            "i.pbroskis@alumnos.upm.es",
            "1234", 
            "000000"
            );
        
        Gestor u2 = new Gestor(
            "Justin", 
            "Drowzee Broskis", 
            "i.pbroskis@alumnos.upm.es",
            "1234", 
            "000001"
            );
        gestorRepository.save(u1);
        gestorRepository.save(u2);

                
    }
    public ArrayList<Gestor> getAllGestors() {
        ArrayList<Gestor> Gestors = new ArrayList<Gestor>();
        gestorRepository.findAll().forEach(Gestor -> Gestors.add(Gestor));
        return Gestors;
    }

    public Gestor getGestorById(Long id) {
        return gestorRepository.findById(id).get();
    }

    public Gestor findByEmail(String email) {
        for (Gestor gestor: getAllGestors()) 
            if (gestor.getEmail().compareTo(email) == 0) {
                return gestor;
            }
        return null;
    }

    public Gestor login(String email, String password, String gestorCode) {
        Gestor gestor = findByEmail(email);
        if (!Objects.nonNull(gestor)) return null;
        if (!(gestor.getPassword().compareTo(password) == 0)) return null;
        if (!(gestor.getPassword().compareTo(password) == 0)) return null;
        return gestor;
    
    }
    public boolean register(Gestor user) {
        gestorRepository.save(user);
        return true;
    }

    public boolean deleteUser(Long id) {
        gestorRepository.deleteById(id);
        return true;
    }

    public Gestor checkExist(String email) {
        if (findByEmail(email) != null) return findByEmail(email);
        return null;
    }

    public Gestor addComunidad(String email, String comunityCode){
        Gestor gestor = new Gestor();
        if (findByEmail(email) != null) gestor = findByEmail(email);
        for (int i = 0; i < gestor.getComunidades().length; i++) {
            if (gestor.getComunidades()[i] == null) {
                gestor.addComunidad(comunityCode, i);
            }
        }
        gestorRepository.save(gestor);
        return gestor;
    }

}
