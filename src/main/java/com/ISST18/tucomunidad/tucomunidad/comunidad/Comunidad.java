package com.ISST18.tucomunidad.tucomunidad.comunidad;

import java.util.ArrayList;

import com.ISST18.tucomunidad.tucomunidad.post.Post;
import com.ISST18.tucomunidad.tucomunidad.reunion.Reunion;
import com.ISST18.tucomunidad.tucomunidad.votacion.Votacion;
import com.ISST18.tucomunidad.tucomunidad.instalaciones.Instalacion;

public class Comunidad {
    static Long nextId = 0L;

    private Long id;
    private String gestorCode;
    private String calle;
    private int numero;
    private String cpostal;
    private String comunityCode;
    private ArrayList<Post> posts;
    private ArrayList<Votacion> votaciones;
    private ArrayList<Instalacion> instalaciones;
    private ArrayList<Reunion> reuniones;

    public Comunidad(
        String gestorCode,
        String calle, 
        int numero,
        String cpostal,
        String comunityCode
    ) {
        this.id = nextId++;
        this.gestorCode = gestorCode;
        this.calle = calle;
        this.numero = numero;
        this.cpostal = cpostal;
        this.comunityCode = comunityCode;
        this.posts = new ArrayList<>();
        this.votaciones = new ArrayList<>();
        this.instalaciones = new ArrayList<>();
        this.reuniones = new ArrayList<>();
    }

    public long getid() {
        return this.id;
    }

    public void setid(long id) {
        this.id = id;
    } 

    public String getGestor() {
        return this.gestorCode;
    }

    public void setGestor(String gestorCode) {
        this.gestorCode = gestorCode;
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

    public Post getPost(Long id) {
        for(int i = 0; i < this.posts.size(); i++)
            if (this.posts.get(i).getId().compareTo(id) == 0)
                return this.posts.get(i);
        return null;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public void addPosts(Post post) {
        this.posts.add(post);
    } 

    public void removePost(Long id) {
        for(int i = 0; i < this.posts.size(); i++) { 
            if (this.posts.get(i).getId().compareTo(id) == 0) {
                posts.remove(i);
                return;
            }
            this.removePost(id, this.posts.get(i).getSubPost());
        }
    } 

    public void removePost(Long id, ArrayList<Post> scope) {
        for(int i = 0; i < scope.size(); i++) { 
            if (scope.get(i).getId().compareTo(id) == 0) {
                scope.remove(i);
                return;
            }
            this.removePost(id, scope.get(i).getSubPost());
        }
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

    public void removeVotacion(Long id) {
        for(int i = 0; i < this.votaciones.size(); i++) 
            if (this.votaciones.get(i).getId().compareTo(id) == 0)
                votaciones.remove(i);
    } 

    public ArrayList<Instalacion> getInstalaciones() {
        return this.instalaciones;
    }

    public int findByInstalacionId(Long id) {
        for (int i = 0; i < this.instalaciones.size(); i++)
            if (this.instalaciones.get(i).getId().compareTo(id) == 0)
                return i;
        return -1;
    }

    public void setInstalaciones(ArrayList<Instalacion> instalaciones) {
        this.instalaciones = instalaciones;
    }

    public void addInstalacion(Instalacion instalacion) {
        this.instalaciones.add(instalacion);
    }

    public ArrayList<Reunion> getReuniones() {
        return this.reuniones;
    }

    public void setReuniones(ArrayList<Reunion> reuniones) {
        this.reuniones = reuniones;
    } 

    public void addReunion(Reunion reunion) {
        this.reuniones.add(reunion);
    }

    public void removeReunion(Long id) {
        for (int i  = 0; i < this.reuniones.size(); i ++)
        if (this.reuniones.get(i).getId().compareTo(id) == 0)
            this.reuniones.remove(i);
    }
}
