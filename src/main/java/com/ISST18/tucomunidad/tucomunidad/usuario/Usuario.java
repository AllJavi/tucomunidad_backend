package com.ISST18.tucomunidad.tucomunidad.usuario;

import java.util.ArrayList;


public class Usuario {
    static Long nextId = 0L;

    private Long id;
    private String nombre;
    private String[] apellidos;
    private String email;
    private String password;
    private String piso;
    private int rol;
    private ArrayList<String> comunidades;

    public Usuario(
        String nombre, 
        String[] apellidos, 
        String email, 
        String password, 
        String piso, 
        int rol
    ) {
        this.id = nextId;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
        this.piso = piso;
        this.rol = rol;
        this.comunidades = new ArrayList<>(); 
        nextId++;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id; 
    } 
    
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String[] apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPiso() {
        return this.piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public int getRol() {
        return this.rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public ArrayList<String> getComunidades() {
        return this.comunidades;
    }

    public void setComunidades(ArrayList<String> comunidades) {
        this.comunidades = comunidades;
    }

    public void addComunidad(String comunityCode) {
        this.comunidades.add(comunityCode);
    }

    @Override
    public String toString() {
        return "Usuario: " + this.id;
    } 

}
