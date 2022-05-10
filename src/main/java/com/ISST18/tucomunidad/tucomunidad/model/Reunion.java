package com.ISST18.tucomunidad.tucomunidad.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import net.minidev.json.JSONObject;

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
    @Column
    private String comunityCode;

    public Reunion() {
    }
    public Reunion(
        String motivo, 
        String fecha,
        boolean presencial,
        String localizacion,
        String comunityCode
    ) {
        this.motivo = motivo;
        this.fecha = fecha;
        this.presencial = presencial;
        this.localizacion = localizacion;
        this.comunityCode = comunityCode;
    }

    @Override
    public String toString() {
        String resStr;
        JSONObject json = new JSONObject();
        json.put("motivo", this.getMotivo());
        json.put("fecha", this.getFecha());
        json.put("presencial", this.getPresencial());
        json.put("localizacion", this.getLocalizacion());
        json.put("comunityCode", this.getComunityCode());

        resStr = json.toString();

        return resStr;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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

    public String getComunityCode() {
        return this.comunityCode;
    }

    public void setComunityCode(String comunityCode) {
        this.comunityCode = comunityCode;
    }

}
