package com.davbossotto.libreria.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "utenti_libri")
public class UtenteLibro {

    @EmbeddedId
    private UtenteLibroId id = new UtenteLibroId();


    @ManyToOne
    @MapsId("idUtente")
    private Utente utente;

    @ManyToOne
    @MapsId("idLibro")
    private Libro libro;

    @CreationTimestamp
    @Column(name = "data_aggiunta", nullable = false)
    private Date dataAggiunta;

    @Column(nullable = true, columnDefinition = "DATE", name="data_eliminazione")
    private String dataEliminazione;


    @Column(nullable = false, name="numero_letture")
    private int nLetture = 0;

    public UtenteLibro(){};
    public UtenteLibro(UtenteLibroId id, Utente utente, Libro libro, Date dataAggiunta, String dataEliminazione, int nLetture) {
        this.id = id;
        this.utente = utente;
        this.libro = libro;
        this.dataAggiunta = dataAggiunta;
        this.dataEliminazione = dataEliminazione;
        this.nLetture = nLetture;
    }


    public UtenteLibroId getId() {
        return id;
    }

    public void setId(UtenteLibroId id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Date getDataAggiunta() {
        return dataAggiunta;
    }

    public void setDataAggiunta(Date dataAggiunta) {
        this.dataAggiunta = dataAggiunta;
    }

    public String getDataEliminazione() {
        return dataEliminazione;
    }

    public void setDataEliminazione(String dataEliminazione) {
        this.dataEliminazione = dataEliminazione;
    }

    public int getnLetture() {
        return nLetture;
    }

    public void setnLetture(int nLetture) {
        this.nLetture = nLetture;
    }

    @Embeddable
    public static class UtenteLibroId implements Serializable {

        private int idLibro;
        private int idUtente;


        public UtenteLibroId(){};
        public UtenteLibroId(int idLibro, int idUtente) {
            super();
            this.idLibro = idLibro;
            this.idUtente = idUtente;
        }

        public int getIdLibro() {
            return idLibro;
        }

        public void setIdLibro(int idLibro) {
            this.idLibro = idLibro;
        }

        public int getIdUtente() {
            return idUtente;
        }

        public void setIdUtente(int idUtente) {
            this.idUtente = idUtente;
        }


    }

}


