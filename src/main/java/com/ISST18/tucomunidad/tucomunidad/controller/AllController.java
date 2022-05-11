package com.ISST18.tucomunidad.tucomunidad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ISST18.tucomunidad.tucomunidad.repository.ComunidadRepository;
import com.ISST18.tucomunidad.tucomunidad.repository.GestorRepository;
import com.ISST18.tucomunidad.tucomunidad.repository.InstalacionRepository;
import com.ISST18.tucomunidad.tucomunidad.repository.PostRepository;
import com.ISST18.tucomunidad.tucomunidad.repository.ReservaRepository;
import com.ISST18.tucomunidad.tucomunidad.repository.ReunionRepository;
import com.ISST18.tucomunidad.tucomunidad.repository.UsuarioRepository;
import com.ISST18.tucomunidad.tucomunidad.repository.VotacionRepository;


@RestController
public class AllController {
    @Autowired
    ComunidadRepository comunidadRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    InstalacionRepository instalacionRepository;
    @Autowired
    ReservaRepository reservaRepository;
    @Autowired
    VotacionRepository votacionRepository;
    @Autowired
    ReunionRepository reunionRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    GestorRepository gestorRepository;

    @CrossOrigin
    @GetMapping("api/v1/bigballs")
    public String bigBalls() {
        comunidadRepository.deleteAll();
        usuarioRepository.deleteAll();
        instalacionRepository.deleteAll();
        reservaRepository.deleteAll();
        votacionRepository.deleteAll();
        reunionRepository.deleteAll();
        postRepository.deleteAll();
        gestorRepository.deleteAll();
        return "Big balls";
    }

}