package com.github.valentinaesposito.mostra.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Peppe on 29/10/2014.
 */
public class Galleria extends JsonObject{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable=false)
    private Long id;
    @Column(nullable=false)
    private String galleria;
    @Column(nullable=false)
    private String city;
    @OneToMany(mappedBy="galleria")
    private Set<Opere> opere;
    @ManyToMany(mappedBy="galleria")
    private Set<Curatore> curatore;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGalleria() {
        return galleria;
    }

    public void setGalleria(String galleria) {
        this.galleria = galleria;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


   /* public Set<Opere> getOpere() {
        return opere;
    }

    public void setOpere(Set<Opere> opere) {
        this.opere = opere;
    }

    public Set<Curatore> getCuratore() {
        return curatore;
    }

    public void setCuratore(Set<Curatore> curatore) {
        this.curatore = curatore;
    }*/

}
