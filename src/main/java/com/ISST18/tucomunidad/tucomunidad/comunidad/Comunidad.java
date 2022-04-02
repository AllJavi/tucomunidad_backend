package com.ISST18.tucomunidad.tucomunidad.comunidad;

import java.util.ArrayList;

import com.ISST18.tucomunidad.tucomunidad.post.Post;
import com.ISST18.tucomunidad.tucomunidad.votacion.Votacion;
import com.ISST18.tucomunidad.tucomunidad.instalaciones.Instalacion;

public class Comunidad {
    static Long nextId = 0L;

    private Long id;
    private String calle;
    private int numero;
    private String cpostal;
    private String comunityCode;
    private ArrayList<Post> posts;
    private ArrayList<Votacion> votaciones;
    private ArrayList<Instalacion> instalaciones;

    public Comunidad(
        String calle, 
        int numero,
        String cpostal,
        String comunityCode
    ) {
        this.id = nextId++;
        this.calle = calle;
        this.numero = numero;
        this.cpostal = cpostal;
        this.comunityCode = comunityCode;
        this.posts = new ArrayList<>();
        this.votaciones = new ArrayList<>();
        this.instalaciones = new ArrayList<>();
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

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCPostal() {
        return this.cpostal;
    }

    public void setCPostal(String cpostal) {
        this.cpostal = cpostal;
    } 

    public String getComunityCode() {
        return this.comunityCode;
    }

    public void setComunityCode(String comunityCode) {
        this.comunityCode = comunityCode;
    } 

    public ArrayList<Post> getPosts() {
        return this.posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public void addPosts(Post post) {
        this.posts.add(post);
    } 

    public ArrayList<Votacion> getVotaciones() {
        return this.votaciones;
    }

    public void setVotaciones(ArrayList<Votacion> votaciones) {
        this.votaciones = votaciones;
    }

    public void addVotacion(Votacion votacion) {
        this.votaciones.add(votacion);
    } 

    public ArrayList<Instalacion> getInstalaciones() {
        return this.instalaciones;
    }

    public void setInstalaciones(ArrayList<Instalacion> instalaciones) {
        this.instalaciones = instalaciones;
    }

    public void addInstalacion(Instalacion instalacion) {
        this.instalaciones.add(instalacion);
    }
}
