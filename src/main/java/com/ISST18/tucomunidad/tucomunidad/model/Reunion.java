package com.ISST18.tucomunidad.tucomunidad.model;

public class Reunion {
    static Long nextId = 0L;

    private Long id;
    private String motivo;
    private String fecha;
    private boolean presencial;
    private String localizacion;

    public Reunion(
        String motivo, 
        String fecha,
        boolean presencial,
        String localizacion
    ) {
        this.id = nextId++;
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
