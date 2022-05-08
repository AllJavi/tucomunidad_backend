package com.ISST18.tucomunidad.tucomunidad.model;

public class ComUser {
    public String email;
    public String password;
    public String comunitycode;

    public ComUser(
        String email,
        String password,
        String comunitycode
    ) {
        this.comunitycode = comunitycode;
        this.password = password;
        this.email = email;
    }
    
}
