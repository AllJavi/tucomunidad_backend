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

    @GeneratedValue
    @Id
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
    private int autorId;
    @Column
    private String comunityCode;

    public Votacion() {
    }
    
    public Votacion(
        String titulo,
        String opcionA,
        String opcionB,
        int autorId,
        String comunityCode
    ) {
      
        this.titulo = titulo;
        this.opcionA = opcionA;
        this.opcionB = opcionB;
        this.autorId = autorId;
        this.comunityCode = comunityCode;
        this.votantesA = new ArrayList<>();
        this.votantesB = new ArrayList<>();
                
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
        this.opcionB = opcionB;
    }

    public int getAutor() {
        return this.autorId;
    }

    public void setAutor(int autorId) {
        this.autorId = autorId;
    }

    public void addOpcionA(Usuario votedUser) {
        this.votantesA.add(votedUser);
    }

    public void addOpcionB(Usuario votedUser) {
        this.votantesB.add(votedUser);
    }

    public String getComunityCode() {
        return this.comunityCode;
    }

    public void setComunityCode(String comunityCode) {
        this.comunityCode = comunityCode;
    }
}
