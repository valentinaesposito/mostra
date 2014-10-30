package com.github.valentinaesposito.mostra.model;

/**
 * Created by Peppe on 29/10/2014.
 */
public class Esposizione {


    Curatore curatore;
    Galleria galleria;

    public Curatore getCuratore() {
        return curatore;
    }

    public void setCuratore(Curatore curatore) {
        this.curatore = curatore;
    }

    public Galleria getGalleria() {
        return galleria;
    }

    public void setGalleria(Galleria galleria) {
        this.galleria = galleria;
    }
}
