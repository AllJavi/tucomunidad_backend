package com.ISST18.tucomunidad.tucomunidad.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Reunion {
    
    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column
    private String motivo;
    @Column
    private String fecha;
    @Column
    private boolean presencial;
    @Column
    private String localizacion;

    public Reunion(
        String motivo, 
        String fecha,
        boolean presencial,
        String localizacion
    ) {
        this.motivo = motivo;
        this.fecha = fecha;
        this.presencial = presencial;
        this.localizacion = localizacion;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    } 

    public String getMotivo() {
        return this.motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean getPresencial() {
        return this.presencial;
    }

    public void setPresencial(Boolean presencial) {
        this.presencial = presencial;
    }

    public String getLocalizacion() {
        return this.localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

}
