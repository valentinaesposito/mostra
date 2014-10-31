package com.github.valentinaesposito.mostra.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Peppe on 27/10/2014.
 */
public class Artisti extends JsonObject{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable=false)
    private Long id;
    @Column(nullable=false)
    private String nomeA;
    @Column(nullable=false)
    private String nazionalita;
    @Column(nullable=false)
    private String correnteArtistica;
    @OneToMany(mappedBy="artisti")
    private Set<Opere> opere;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeA() {

        return nomeA;
    }

    public void setNomeA(String nomeA) {

        this.nomeA = nomeA;
    }

    public String getNazionalita() {

        return nazionalita;
    }

    public void setNazionalita(String nazionalita) {

        this.nazionalita = nazionalita;
    }

    public String getCorrenteArtistica() {
        return correnteArtistica;
    }

    public void setCorrenteArtistica(String correnteArtistica) {
        this.correnteArtistica = correnteArtistica;
    }


   /*public Set<Opere> getOpere() {
        return opere;
    }

    public void setOpere(Set<Opere> opere) {
        this.opere = opere;
    }*/

}
