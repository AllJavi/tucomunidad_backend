package com.ISST18.tucomunidad.tucomunidad.instalaciones;

import com.ISST18.tucomunidad.tucomunidad.usuario.Usuario;

public class Reserva {
    static Long nextId = 0L;

    private Long id;
    private int horaInicio;
    private int horaFin;
    private Usuario usuario;

    public Reserva(
        int horaInicio,
        int horaFin,
        Usuario usuario
    ) {
        this.id = nextId++;
        this.horaInicio = horaFin;
        this.horaFin = horaFin;
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
