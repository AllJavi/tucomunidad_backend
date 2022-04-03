package com.ISST18.tucomunidad.tucomunidad.instalaciones;

import java.util.ArrayList;

public class Instalacion {
    static Long nextId = 0L;

    private Long id;
    private String nombre;
    private int horaInicio;
    private int horaFin;
    private int intervalo;
    private ArrayList<Reserva> reservas;
    private int precio;

    public Instalacion(
        String nombre,
        int horaInicio,
        int horaFin,
        int intervalo,
        int precio
    ) {
        this.id = nextId++;
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.intervalo = intervalo;
        this.reservas =  new ArrayList<>();
        this.precio = precio;
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

    public int getIntervalo() {
        return this.intervalo;
    }

    public void setIntervalo(int intervalo) {
        this.intervalo = intervalo;
    }
    
    public ArrayList<Reserva> getReservas() {
        return this.reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }
    
    public void addReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    public int getPrecio() {
        return this.precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
