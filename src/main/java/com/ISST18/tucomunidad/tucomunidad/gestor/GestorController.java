package com.ISST18.tucomunidad.tucomunidad.gestor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Objects;

@RestController
public class GestorController {
    
    private ArrayList<Gestor> gestores;

    public GestorController() {
        this.gestores = new ArrayList<>();
        Gestor u1 = new Gestor(
            "Ivan", 
            new String[]{"Perez", "Broskis"}, 
            "i.pbroskis@alumnos.upm.es",
            "1234", 
            "000000"
            );
        this.gestores.add(u1);
        Gestor u2 = new Gestor(
            "Justin", 
            new String[]{"Drowzee", "Broskis"}, 
            "i.pbroskis@alumnos.upm.es",
            "1234", 
            "000001"
            );
        this.gestores.add(u2);
                
    }

    private Gestor findByEmail(String email) {
        for (Gestor gestor: this.gestores) 
            if (gestor.getEmail().compareTo(email) == 0) return gestor;
        return null;
    }

    @RequestMapping(path = "api/v1/gestor")
    @ResponseBody
    public ArrayList<Gestor> showAll() {
        return this.gestores;
    }
    
    @CrossOrigin
    @RequestMapping(path = "api/v1/gestor/login")
    @ResponseBody
    public Gestor login(@RequestParam String email, @RequestParam String numAdmin, @RequestParam String password) {
        Gestor gestor = findByEmail(email);
        if (!Objects.nonNull(gestor)) return null;
        if (!(gestor.getNumAdmin().compareTo(numAdmin) == 0)) return null;
        if (!(gestor.getPassword().compareTo(password) == 0)) return null;
        return gestor;
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/gestor/register")
    public boolean register(@RequestBody Gestor gestor) {
        this.gestores.add(gestor);
        return true;
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/gestor/registerComunity")
    public boolean addComunity(@RequestParam String ComunityCode, @RequestParam String email){
        Gestor gestor = findByEmail(email);
        gestor.addComunidad(ComunityCode);
        return true;
    }
   

}
