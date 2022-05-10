package com.ISST18.tucomunidad.tucomunidad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import com.ISST18.tucomunidad.tucomunidad.model.ComUser;
import com.ISST18.tucomunidad.tucomunidad.model.Usuario;
import com.ISST18.tucomunidad.tucomunidad.service.UsuarioService;

@RestController
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping("api/v1/usuario/load")
    public void seedUsers(){
        usuarioService.seedUsers();
    }
    @GetMapping("/usuario/{id}") 
    private Usuario findByEmail(@PathVariable("id") String email) {
        // for (Usuario user: this.usuarios) 
        //     if (user.getEmail().compareTo(email) == 0) return user;
        // return null;
        return usuarioService.findByEmail(email);
    }

    @GetMapping("api/v1/usuario")
    @ResponseBody
    public ArrayList<Usuario> getAllUsuarios() {
        // return this.usuarios;
        return usuarioService.getAllUsuarios();
    }
    
    @CrossOrigin
    @GetMapping("api/v1/usuario/login")
    @ResponseBody
    public Usuario login(@RequestParam String email, @RequestParam String password) {
        // Usuario user = findByEmail(email);
        // if (!Objects.nonNull(user)) return null;

        // if (!(user.getPassword().compareTo(password) == 0)) return null;
        // return user;
        return usuarioService.login(email, password);
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/usuario/register")
    public boolean register(@RequestBody Usuario user) {
        // this.usuarios.add(user);
        // return true;
        return usuarioService.register(user);
    }

    @CrossOrigin
    @GetMapping(path = "api/v1/usuario/delete/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        // this.usuarios.add(user);
        // return true;
        return usuarioService.deleteUser(id);
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/usuario/comunidad")
    public boolean addComunity(
        @RequestBody ComUser data) {
        // Usuario user = this.login(data.email, data.password);
        // if (Objects.nonNull(user))
        //     user.addComunidad(data.comunitycode);
        // return true;
        return usuarioService.addComunity(data);
    }

}
