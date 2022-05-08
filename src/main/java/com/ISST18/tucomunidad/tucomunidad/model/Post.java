package com.ISST18.tucomunidad.tucomunidad.model;

import java.util.ArrayList;

public class Post {
    static Long nextId = 0L;

    private Long id;
    private String titulo;
    private String cuerpo;
    private Usuario autor;
    private ArrayList<Usuario> upvoted;
    private ArrayList<Post> respuestas;

    public Post(
        String titulo,
        String cuerpo,
        Usuario autor
    ) {
        this.id = nextId++;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.autor = autor;
        this.upvoted = new ArrayList<>();
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

    public Usuario getAutor() {
        return this.autor;
    }

    public ArrayList<Usuario> getUpvoted() {
        return this.upvoted;
    }

    public void setUpvoted(ArrayList<Usuario> upvoted) {
        this.upvoted = upvoted;
    }

    public void newUpvoted(Usuario upvoted) {
        for (int i = 0; i < this.upvoted.size(); i++)
            if (upvoted.getId().compareTo(this.upvoted.get(i).getId()) == 0) {
                this.upvoted.remove(i);
                return;
            }
        this.upvoted.add(upvoted);
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
