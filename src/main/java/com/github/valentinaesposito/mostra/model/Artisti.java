package com.github.valentinaesposito.mostra.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Peppe on 27/10/2014.
 */
@Entity
public class Artisti extends JsonObject{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable=false)
    private Long idA;
    @Column(nullable=false)
    private String nomeA;
    @Column(nullable=false)
    private String nazionalita;
    @Column(nullable=false)
    private String correnteArtistica;
    @OneToMany(mappedBy="artisti")
    private Set<Opere> opere;

    public Long getIdA() {
        return idA;
    }

    public void setIdA(Long idA) {
        this.idA = idA;
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


   public Set<Opere> getOpere() {
        return opere;
    }

    public void setOpere(Set<Opere> opere) {
        this.opere = opere;
    }

}
