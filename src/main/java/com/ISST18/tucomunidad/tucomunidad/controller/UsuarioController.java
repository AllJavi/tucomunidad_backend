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

import net.minidev.json.JSONObject;

import java.util.ArrayList;

import com.ISST18.tucomunidad.tucomunidad.model.ComUser;
import com.ISST18.tucomunidad.tucomunidad.model.Usuario;
import com.ISST18.tucomunidad.tucomunidad.service.UsuarioService;

@RestController
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    
    @CrossOrigin
    @GetMapping("api/v1/usuario/load")
    public void seedUsers(){
        usuarioService.seedUsers();
    }
    @CrossOrigin
    @GetMapping("/usuario/{id}") 
    private Usuario findByEmail(@PathVariable("id") String email) {
        // for (Usuario user: this.usuarios) 
        //     if (user.getEmail().compareTo(email) == 0) return user;
        // return null;
        return usuarioService.findByEmail(email);
    }
    @CrossOrigin
    @GetMapping("api/v1/usuario")
    @ResponseBody
    public ArrayList<Usuario> getAllUsuarios() {
        // return this.usuarios;
        return usuarioService.getAllUsuarios();
    }
    
    @CrossOrigin
    @GetMapping("api/v1/usuario/login")
    @ResponseBody
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        
        Usuario usuario =  usuarioService.login(email, password);
        String usuarioStr;
        JSONObject json = new JSONObject();
        json.put("id", usuario.getId());
        json.put("nombre", usuario.getNombre());
        json.put("apellidos", usuario.getApellidos());
        json.put("email", usuario.getEmail());
        json.put("password", usuario.getPassword());
        json.put("piso", usuario.getPiso());
        json.put("rol", usuario.getRol());
        json.put("comunidades", usuario.getComunidades());
               
        usuarioStr = json.toString();
        return ResponseEntity.ok().body(usuarioStr);
                
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
