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

    // private ArrayList<Usuario> usuarios;

    // public UsuarioController() {
    //     this.usuarios = new ArrayList<>();
    //     Usuario u1 = new Usuario(
    //         "Pedro", 
    //         new String[]{"Perez", "Garcia"}, 
    //         "p.pgarcia@alumnos.upm.com",
    //         "1234", 
    //         "2A"
    //         );
    //     this.usuarios.add(u1);
    //     Usuario u2 = new Usuario(
    //         "Monica", 
    //         new String[]{"Rodriguez", "Laranjo"}, 
    //         "m.rmunoz@alumnos.upm.com",
    //         "1234", 
    //         "1A"
    //         );
    //     this.usuarios.add(u2);
    //     Usuario u3 = new Usuario(
    //         "Carlos", 
    //         new String[]{"De la Fuente", "Garcia"}, 
    //         "c.fgarcia@alumnos.upm.com",
    //         "1234", 
    //         "1B"
    //         );
    //     this.usuarios.add(u3);
    //     Usuario u4 = new Usuario(
    //         "Maria", 
    //         new String[]{"Perez", "Lopez"}, 
    //         "m.plopez@alumnos.upm.com",
    //         "1234", 
    //         "2B"
    //         );
    //     this.usuarios.add(u4);
    //     Usuario u5 = new Usuario(
    //         "Marta", 
    //         new String[]{"Sanchez", "Jones"}, 
    //         "m.sjones@alumnos.upm.com",
    //         "1234", 
    //         "3"
    //         );
    //     this.usuarios.add(u5);

    //     Usuario u6 = new Usuario(
    //         "Alonso", 
    //         new String[]{"Perez", "Rodriguez"}, 
    //         "a.prodriguez@alumnos.upm.com",
    //         "1234", 
    //         "-1"
    //         );
    //     this.usuarios.add(u6);

    //     for (int i = 0; i < this.usuarios.size(); i++)
    //         this.usuarios.get(i).addComunidad("1957");
    // }
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
