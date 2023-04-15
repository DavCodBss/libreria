package com.davbossotto.libreria.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, name="id")
    private int id;

    @Column(nullable = false, name="nome")
    private String nome;

    @Column(nullable = false, name="cognome")
    private String cognome;

    @Column(unique = true, nullable = false, name="email")
    private String email;

    @Column(name="foto_profilo")
    private String fotoProfilo;

    public Utente(){};

    public Utente(String nome, String cognome, String email, String fotoProfilo) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.fotoProfilo = fotoProfilo;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public String getFotoProfilo() {
        return fotoProfilo;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFotoProfilo(String fotoProfilo) {
        this.fotoProfilo = fotoProfilo;
    }


}
