package com.ISST18.tucomunidad.tucomunidad.comunidad;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ISST18.tucomunidad.tucomunidad.usuario.Usuario;
import com.ISST18.tucomunidad.tucomunidad.post.Post;
import com.ISST18.tucomunidad.tucomunidad.votacion.Votacion;
import com.ISST18.tucomunidad.tucomunidad.instalaciones.Instalacion;

import java.util.ArrayList;

@RestController
public class ComunidadController {
    private ArrayList<Comunidad> comunidades;

    public ComunidadController() {
        this.comunidades = new ArrayList<>();
        Comunidad c1 = new Comunidad(
            "Av. Complutense", 
            30, 
            "28040", 
            "1957");

        Instalacion piscina = new Instalacion(
            "piscina",
            800,
            2000,
            60,
            0
        );
        c1.addInstalacion(piscina);

        Instalacion padel = new Instalacion(
            "padel",
            1000,
            2200,
            30,
            5
        );
        c1.addInstalacion(padel);

        this.comunidades.add(c1);
        
        
    }

    private Comunidad findByComunityCode(String comunityCode) {
        for (Comunidad comunidad: this.comunidades) 
            if (comunidad.getComunityCode().compareTo(comunityCode) == 0)
                return comunidad;
        return null;
    }


    @CrossOrigin
    @RequestMapping(path = "api/v1/comunidad/{comunityCode}")
    @ResponseBody
    public Comunidad info(@PathVariable String comunityCode) {
        return findByComunityCode(comunityCode);
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/comunidad/{comunityCode}/post")
    public boolean newPost(@PathVariable String comunityCode, @RequestBody Post post) {
        Comunidad comunidad = findByComunityCode(comunityCode);
        comunidad.addPosts(post);
        return true;
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/comunidad/{comunityCode}/post/{postId}")
    public boolean upVotedPost(
        @PathVariable String comunityCode, 
        @PathVariable Long postId,
        @RequestBody Usuario upvoted) {
        Comunidad comunidad = findByComunityCode(comunityCode);
        comunidad.getPost(postId).newUpvoted(upvoted);
        return true;
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/comunidad/{comunityCode}/post/delete")
    public boolean deletePost(@PathVariable String comunityCode, @RequestBody Long id) {
        Comunidad comunidad = findByComunityCode(comunityCode);
        comunidad.removePost(id);
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
    
}
