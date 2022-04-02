package com.ISST18.tucomunidad.tucomunidad.usuario;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Objects;

@RestController
public class UsuarioController {

    private ArrayList<Usuario> usuarios;

    public UsuarioController() {
        this.usuarios = new ArrayList<>();
        Usuario u1 = new Usuario("a", new String[]{"a", "b"}, "b", "c", "d", 0);
        this.usuarios.add(u1);
    }

    private Usuario findByEmail(String email) {
        for (Usuario user: this.usuarios) 
            if (user.getEmail().compareTo(email) == 0) return user;
        return null;
    }
    
    @RequestMapping(path = "api/v1/usuario/login")
    @ResponseBody
    public Usuario login(@RequestParam String email, @RequestParam String password) {
        Usuario user = findByEmail(email);
        if (!Objects.nonNull(user)) return null;

        if (!(user.getPassword().compareTo(password) == 0)) return null;
        return user;
    }

    @PostMapping(path = "api/v1/usuario/register")
    public boolean register(@RequestBody Usuario user) {
        this.usuarios.add(user);
        return true;
    }

    // TODO: Repasar esta mierda de codigo
    @PutMapping(path = "api/v1/usuario/comunidad/{comunityCode}")
    public void addComunity(
        @PathVariable String comunityCode, 
        @RequestParam String email, 
        @RequestParam String password) {
        for (int i = 0; i < this.usuarios.size(); i++) { 
            Usuario user = this.usuarios.get(i);
            if (user.getEmail().compareTo(email) == 0) {
                if (user.getPassword().compareTo(password) == 0)
                    this.usuarios.get(i).addComunidad(comunityCode);
                break;
            }
        }
    }

}
