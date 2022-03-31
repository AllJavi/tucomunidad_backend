package com.ISST18.tucomunidad.tucomunidad.comunidad;

import java.util.ArrayList;

public class Comunidad {
    private Long id;
    private String calle;
    private ArrayList<Integer> numero;
    private String cpostal;

    public Comunidad(
        Long id,
        String calle, 
        ArrayList<Integer> numero,
        String cpostal
    ) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.cpostal = cpostal;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    } 

    public String getCalle() {
        return this.calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public ArrayList<Integer> getNumero() {
        return this.numero;
    }

    public void setNumero(ArrayList<Integer> numero) {
        this.numero = numero;
    }

    public String getCPostal() {
        return this.cpostal;
    }

    public void setCPostal(String cpostal) {
        this.cpostal = cpostal;
    } 
}
