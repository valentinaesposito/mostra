package com.github.valentinaesposito.mostra.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Peppe on 29/10/2014.
 */
@Entity
public class Galleria extends JsonObject{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable=false)
    private Long idG;
    @Column(nullable=false)
    private String galleria;
    @Column(nullable=false)
    private String city;
    @OneToMany(mappedBy="gallery",fetch=FetchType.EAGER)
    private Set<Opere> opere;
    @ManyToMany(mappedBy="galleria",fetch=FetchType.EAGER)
    private Set<Curatore> curatore;


    public Long getIdG() {
        return idG;
    }

    public void setIdG(Long idG) {
        this.idG = idG;
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

    public Set<Opere> getOpere() {
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
    }

}
