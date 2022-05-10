package com.ISST18.tucomunidad.tucomunidad.model;


    
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Gestor {
    
    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column
    private String nombre;
    @Column
    private String apellidos;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String numAdmin;
    @Column
    private String[] comunidades;

    public Gestor() {
    }
    
    public Gestor(
        String nombre, 
        String apellidos, 
        String email, 
        String password,
        String numAdmin 
    ) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
        this.numAdmin= numAdmin;
        this.comunidades= new String[100]; 
        
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

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumAdmin() {
        return this.numAdmin;
    }

    public void setNumAdmin(String numAdmin) {
        this.numAdmin = numAdmin;
    }

    public String[] getComunidades() {
        return this.comunidades;
    }

    public void setComunidades(String[] comunidades) {
        this.comunidades = comunidades;
    }
    public void addComunidad(String ComunityCode, int i) {
        this.comunidades[i] = ComunityCode;
    }

    @Override
    public String toString() {
        return "Gestor: " + this.id;
    } 

}

