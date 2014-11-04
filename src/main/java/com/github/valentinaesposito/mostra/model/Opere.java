package com.github.valentinaesposito.mostra.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Peppe on 27/10/2014.
 */
@Entity
public class Opere extends JsonObject {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable=false)
    private Long idO;
    @Column(nullable=false)
    private String titolo;
    @ManyToOne
    @JoinColumn(nullable=false)
    private Artisti artista;
    @ManyToOne
    @JoinColumn(nullable=false)
    private Galleria gallery;


    public Long getIdO() {
        return idO;
    }

    public void setIdO(Long idO) {
        this.idO = idO;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Artisti getArtista() {
        return artista;
    }

    public void setArtista(Artisti artista) {
        this.artista = artista;
    }

    public Galleria getGallery() {
        return gallery;
    }

    public void setGallery(Galleria gallery) {
        this.gallery = gallery;
    }

}

