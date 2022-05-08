package com.ISST18.tucomunidad.tucomunidad.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Post {
    @Id
    @Column
    private Long id;
    @Column
    private String titulo;
    @Column
    private String cuerpo;
    @Column
    private long autorId;
    @Column
    private long comunidadId;
    @Column
    public int upvoted;
    @Column
    private ArrayList<Post> respuestas;
    

    public Post(
        String titulo,
        String cuerpo,
        long autorId,
        long comunidadId
    ) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.autorId = autorId;
        this.comunidadId = comunidadId;
        this.upvoted = 0;
        this.respuestas = new ArrayList<>();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    } 

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return this.cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public long getAutor() {
        return this.autorId;
    }

    public void setAutor(long autorId) {
        this.autorId = autorId;
    }

    public long getComunidadId() {
        return this.comunidadId;
    }

    public void setComunidadId(long comunidadId) {
        this.comunidadId = comunidadId;
    }

    public int getUpvoted() {
        return this.upvoted;
    }

    public void setUpvoted(int upvoted) {
        this.upvoted = upvoted;
    }

    public ArrayList<Post> getSubPost() {
        return this.respuestas;
    }

    public void setSubPost(ArrayList<Post> respuestas) {
        this.respuestas = respuestas;
    }

    public void newSubPost(Post respuesta) {
        this.respuestas.add(respuesta);
    }

    public void removeSubPost(Long id) {
        for (int i = 0; i < this.respuestas.size(); i++) {
            if (this.respuestas.get(i).getId().compareTo(id) == 0) {
                this.respuestas.remove(i);
                return;
            }
        }
    }
}
