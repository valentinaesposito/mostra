package com.github.valentinaesposito.mostra.model;

/**
 * Created by Peppe on 27/10/2014.
 */
public class Opere {

    private String titolo;
    private String nomeG; // nome galleria d'esposizione
    private String nomeA;
    private Artisti artista;

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getNomeG() {
        return nomeG;
    }

    public void setNomeG(String nomeG) {
        this.nomeG = nomeG;
    }

    public String getNomeA() {
        return nomeA;
    }

    public void setNomeA(String nomeA) {
        this.nomeA = nomeA;
    }

    public Artisti getArtista() {
        return artista;
    }

    public void setArtista(Artisti artista) {
        this.artista = artista;
    }

}

