package com.ISST18.tucomunidad.tucomunidad.comunidad;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ISST18.tucomunidad.tucomunidad.post.Post;
import com.ISST18.tucomunidad.tucomunidad.votacion.Votacion;

import java.util.ArrayList;

@RestController
public class ComunidadController {
    private ArrayList<Comunidad> comunidades;

    public ComunidadController() {
        this.comunidades = new ArrayList<>();
        Comunidad c1 = new Comunidad("a", 16, "21234", "1234");
        this.comunidades.add(c1);
        
    }

    private Comunidad findByComunityCode(String comunityCode) {
        for (Comunidad comunidad: this.comunidades) 
            if (comunidad.getComunityCode().compareTo(comunityCode) == 0)
                return comunidad;
        return null;
    }


    @RequestMapping(path = "api/v1/comunidad/{comunityCode}")
    @ResponseBody
    public Comunidad info(@PathVariable String comunityCode) {
        return findByComunityCode(comunityCode);
    }

    @PostMapping(path = "api/v1/comunidad/{comunityCode}/post")
    public boolean newPost(@PathVariable String comunityCode, @RequestBody Post post) {
        Comunidad comunidad = findByComunityCode(comunityCode);
        comunidad.addPosts(post);
        return true;
    }

    @PostMapping(path = "api/v1/comunidad/{comunityCode}/votacion")
    public boolean newVotacion(@PathVariable String comunityCode, @RequestBody Votacion votacion) {
        Comunidad comunidad = findByComunityCode(comunityCode);
        comunidad.addVotacion(votacion);
        return true;
    }
    
}
