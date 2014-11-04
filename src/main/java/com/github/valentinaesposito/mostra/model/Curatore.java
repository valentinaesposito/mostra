package com.github.valentinaesposito.mostra.model;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * Created by Peppe on 27/10/2014.
 */
@Entity
public class Curatore extends JsonObject{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable=false)
    private Long idC;
    @Column(nullable=false)
    private String username;
    @Column(nullable=false)
    private String password;
    @OneToOne
    @JoinColumn(nullable=false)
    private Profilo profilo;
    @ManyToMany(mappedBy="curatore")
    private Set<Galleria> galleria;



    public Curatore() {}

    public Curatore(HttpServletRequest request) throws Exception {
        this.username = this.validate(String.class, request.getParameter("username"));
        this.password = this.validate(String.class, request.getParameter("password"));
    }

    public Long getIdC() {
        return idC;
    }

    public void setIdC(Long idC) {
        this.idC = idC;
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

    public Profilo getProfilo() {
        return profilo;
    }

    public void setProfilo(Profilo profilo) {
        this.profilo = profilo;
    }


    public Set<Galleria> getGalleria() {
        return galleria;
    }

    public void setGalleria(Set<Galleria> galleria) {
        this.galleria = galleria;
    }

}

