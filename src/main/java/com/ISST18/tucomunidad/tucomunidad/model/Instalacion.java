package com.ISST18.tucomunidad.tucomunidad.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import net.minidev.json.JSONObject;

@Entity
@Table
public class Instalacion {
    
    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column
    private String nombre;
    @Column
    private String url;
    @Column
    private int horaInicio;
    @Column
    private int horaFin;
    @Column
    private int intervalo;
    @Column
    private ArrayList<Reserva> reservas;
    @Column
    private int precio;
    @Column
    private String comunityCode;

    public Instalacion() {
    }
    public Instalacion(
        String nombre,
        String url,
        int horaInicio,
        int horaFin,
        int intervalo,
        int precio,
        String comunityCode
    ) {
        this.nombre = nombre;
        this.url = url;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.intervalo = intervalo;
        this.reservas =  new ArrayList<>();
        this.precio = precio;
        this.comunityCode = comunityCode;
    }

    @Override
    public String toString() {
        String instalacionStr;
        JSONObject json = new JSONObject();
        json.put("nombre", this.getNombre());
        json.put("url", this.getUrl());
        json.put("horaInicio", this.getHoraInicio());
        json.put("horaFin", this.getHoraFin());
        json.put("intervalo", this.getIntervalo());
        json.put("reservas", this.getReservas());
        json.put("precio", this.getPrecio());
        json.put("comunityCode", this.getComunityCode());

        instalacionStr = json.toString();
        return instalacionStr;
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

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public void removeReserva(Long id) {
        for (int i = 0; i < this.reservas.size(); i++) {
            if (this.reservas.get(i).getId().compareTo(id) == 0) {
                this.reservas.remove(i);
                return;
            }
        }
    }

    public int getPrecio() {
        return this.precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getComunityCode() {
        return this.comunityCode;
    }

    public void setComunityCode(String comunityCode) {
        this.comunityCode = comunityCode;
    }
}
