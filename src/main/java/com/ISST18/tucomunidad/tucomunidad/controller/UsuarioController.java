package com.ISST18.tucomunidad.tucomunidad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private ResponseEntity<String> findByEmail(@PathVariable("id") String email) {
        // for (Usuario user: this.usuarios) 
        //     if (user.getEmail().compareTo(email) == 0) return user;
        // return null;
        return ResponseEntity.ok().body(usuarioService.findByEmail(email).toString2());
    }

    @GetMapping("api/v1/usuario")
    @ResponseBody
    public ResponseEntity<ArrayList<String>> showAll() {
        ArrayList<String> usrStr = new ArrayList<String>();
        for (Usuario usr : usuarioService.getAllUsuarios()){
            usrStr.add(usr.toString());
        }
        return ResponseEntity.ok().body(usrStr); 
    }
    
    @CrossOrigin
    @GetMapping("api/v1/usuario/login")
    @ResponseBody
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        Usuario usuario =  usuarioService.login(email, password);
        return ResponseEntity.ok().body(usuario.toString2());
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/usuario/register")
    public ResponseEntity<Boolean> register(@RequestBody Usuario user) {
        // this.usuarios.add(user);
        // return true;
        return ResponseEntity.ok().body(usuarioService.register(user));
    }

    @CrossOrigin
    @GetMapping(path = "api/v1/usuario/delete/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
        // this.usuarios.add(user);
        // return true;
        return ResponseEntity.ok().body(usuarioService.deleteUser(id));
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/usuario/comunidad")
    public ResponseEntity<Boolean> addComunity(
        @RequestBody ComUser data) {
        // Usuario user = this.login(data.email, data.password);
        // if (Objects.nonNull(user))
        //     user.addComunidad(data.comunitycode);
        // return true;
        return ResponseEntity.ok().body(usuarioService.addComunity(data));
    }

}
