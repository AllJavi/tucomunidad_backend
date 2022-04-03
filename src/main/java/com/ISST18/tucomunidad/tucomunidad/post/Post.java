package com.ISST18.tucomunidad.tucomunidad.post;

import com.ISST18.tucomunidad.tucomunidad.usuario.Usuario;

import java.util.ArrayList;

public class Post {
    static Long nextId = 0L;

    private Long id;
    private String titulo;
    private String cuerpo;
    private Usuario autor;
    private ArrayList<Usuario> upvoted;

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
        this.upvoted.add(upvoted);
    }
}
