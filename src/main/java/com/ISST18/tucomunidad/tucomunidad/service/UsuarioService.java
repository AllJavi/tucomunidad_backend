package com.ISST18.tucomunidad.tucomunidad.service;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ISST18.tucomunidad.tucomunidad.model.ComUser;
import com.ISST18.tucomunidad.tucomunidad.model.Usuario;
import com.ISST18.tucomunidad.tucomunidad.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
   
    public void seedUsers() {
        ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();
        usuarioRepository.findAll().forEach(Usuario -> Usuarios.add(Usuario));
        Usuario u1 = new Usuario(
            "Pedro", 
            "Perez Garcia", 
            "p.pgarcia@alumnos.upm.com",
            "1234", 
            "2A"
            );
        
        Usuario u2 = new Usuario(
            "Monica", 
            "Rodriguez Laranjo", 
            "m.rmunoz@alumnos.upm.com",
            "1234", 
            "1A"
            );
        
        Usuario u3 = new Usuario(
            "Carlos", 
            "De la Fuente Garcia", 
            "c.fgarcia@alumnos.upm.com",
            "1234", 
            "1B"
            );
        
        Usuario u4 = new Usuario(
            "Maria", 
            "Perez Lopez", 
            "m.plopez@alumnos.upm.com",
            "1234", 
            "2B"
            );
        
        Usuario u5 = new Usuario(
            "Marta", 
            "Sanchez Jones", 
            "m.sjones@alumnos.upm.com",
            "1234", 
            "3"
            );
        

        Usuario u6 = new Usuario(
            "Alonso", 
            "Perez Rodriguez", 
            "a.prodriguez@alumnos.upm.com",
            "1234", 
            "-1"
            );
        
                        
        usuarioRepository.save(u1);
        usuarioRepository.save(u2);
        usuarioRepository.save(u3);
        usuarioRepository.save(u4);
        usuarioRepository.save(u5);
        usuarioRepository.save(u6);

    }
    public ArrayList<Usuario> getAllUsuarios() {
        ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();
        usuarioRepository.findAll().forEach(Usuario -> Usuarios.add(Usuario));
        return Usuarios;
    }

    public Usuario getUsuarioById(long id) {
        return usuarioRepository.findById(id).get();
    }

    public Usuario findByEmail(String email) {
        ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();
        usuarioRepository.findAll().forEach(Usuario -> Usuarios.add(Usuario));
        for (Usuario user: Usuarios) 
            if (user.getEmail().compareTo(email) == 0) return user;
        return null;
    }

    public Usuario login(String email, String password) {
        Usuario user = findByEmail(email);
        if (!Objects.nonNull(user)) return null;

        if (!(user.getPassword().compareTo(password) == 0)) return null;
        return user;
    
    }
    public boolean register(Usuario user) {
        usuarioRepository.save(user);
        return true;
    }

    public boolean deleteUser(long id) {
        usuarioRepository.deleteById(id);
        return true;
    }

    public boolean addComunity(ComUser data){
        Usuario user = login(data.email, data.password);
        if (Objects.nonNull(user))
            user.addComunidad(data.comunitycode);
        return true;
    }
}
