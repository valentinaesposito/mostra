package com.github.valentinaesposito.mostra.model;

/**
 * Created by Peppe on 27/10/2014.
 */
public class Curatore {


    private String username;
    private String password;
    Profilo profilo;

    public Profilo getProfilo() {
        return profilo;
    }

    public void setProfilo(Profilo profilo) {
        this.profilo = profilo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

