package com.github.valentinaesposito.mostra.model;

import javax.persistence.*;

/**
 * Created by Peppe on 27/10/2014.
 */
@Entity
public class Profilo extends JsonObject{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable=false)
    private Long idP;
    @Column(nullable=false)
    private String nome;
    @Column(nullable=false)
    private String cognome;
    @Column(nullable=false)
    private String mail;
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(nullable=false)
    private Curatore curatore;


    public Long getIdP() {
        return idP;
    }

    public void setIdP(Long idP) {
        this.idP = idP;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Curatore getCuratore() {
        return curatore;
    }

    public void setCuratore(Curatore curatore) {
        this.curatore = curatore;
    }

}

