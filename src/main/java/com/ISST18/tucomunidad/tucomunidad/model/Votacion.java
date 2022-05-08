package com.ISST18.tucomunidad.tucomunidad.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Votacion {

    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column
    private String titulo;  
    @Column
    private String opcionA;
    @Column
    private ArrayList<Usuario> votantesA;
    @Column
    private String opcionB;
    @Column
    private ArrayList<Usuario> votantesB;
    @Column
    private long autorId;

    public Votacion() {
    }
    
    public Votacion(
        String titulo,
        String opcionA,
        String opcionB,
        long autorId
    ) {
      
        this.titulo = titulo;
        this.opcionA = opcionA;
        this.votantesA = new ArrayList<>();
        this.opcionB = opcionB;
        this.votantesB = new ArrayList<>();
        this.autorId = autorId;
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

    public long getAutor() {
        return this.autorId;
    }

    public void setAutor(long autorId) {
        this.autorId = autorId;
    }

    public void addOpcionA(Usuario votedUser) {
        this.votantesA.add(votedUser);
    }

    public void addOpcionB(Usuario votedUser) {
        this.votantesB.add(votedUser);
    }
}
