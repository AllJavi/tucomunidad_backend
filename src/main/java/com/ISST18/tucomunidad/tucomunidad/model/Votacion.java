package com.ISST18.tucomunidad.tucomunidad.model;

import java.util.ArrayList;

public class Votacion {
    static Long nextId = 0L;

    private Long id;
    private String titulo;
    private String opcionA;
    private ArrayList<Usuario> votantesA;
    private String opcionB;
    private ArrayList<Usuario> votantesB;
    private Usuario autor;

    public Votacion(
        String titulo,
        String opcionA,
        String opcionB,
        Usuario autor
    ) {
        this.id = nextId++;
        this.titulo = titulo;
        this.opcionA = opcionA;
        this.votantesA = new ArrayList<>();
        this.opcionB = opcionB;
        this.votantesB = new ArrayList<>();
        this.autor = autor;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    } 

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getOpcionA() {
        return this.opcionA;
    }

    public void setOpcionA(String opcionA) {
        this.opcionA = opcionA;
    }

    public String getOpcionB() {
        return this.opcionB;
    }

    public void setOpcionB(String opcionB) {
        this.opcionA = opcionB;
    }

    public Usuario getAutor() {
        return this.autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public void addOpcionA(Usuario votedUser) {
        this.votantesA.add(votedUser);
    }

    public void addOpcionB(Usuario votedUser) {
        this.votantesB.add(votedUser);
    }
}
