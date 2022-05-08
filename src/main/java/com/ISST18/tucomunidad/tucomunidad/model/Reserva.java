package com.ISST18.tucomunidad.tucomunidad.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Reserva {
    
    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column
    private int horaInicio;
    @Column
    private int horaFin;
    @Column
    private long userId;
    @Column
    public Long comunidadId;
    @Column
    private Long instalacionId;


    public Reserva(
        int horaInicio,
        int horaFin,
        long userId,
        Long comunidadId,
        Long instalacionId
    ) {
        this.horaInicio = horaFin;
        this.horaFin = horaFin;
        this.userId = userId;
        this.comunidadId = comunidadId;
        this.instalacionId = instalacionId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    } 

    public int getHoraInicio() {
        return this.horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFin() {
        return this.horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }

    public long getUsuario() {
        return this.userId;
    }

    public void setUsuario(long userId) {
        this.userId = userId;
    }

    public Long getComunidadId() {
        return this.comunidadId;
    }

    public void setComunidadId(Long comunidadId) {
        this.comunidadId = comunidadId;
    }

    public Long getInstalacionId() {
        return this.instalacionId;
    }

    public void setInstalacionId(Long instalacionId) {
        this.instalacionId = instalacionId;
    }
}
