package com.davbossotto.libreria.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "libri")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, name="id")
    private int id;

    @Column(nullable = false, name="titolo")
    private String titolo;

    @Column(nullable = false, length = 13, name="isbn")
    private String isbn;

    @Column(nullable = false, columnDefinition = "DATE", name="data_pubblicazione")
    private String dataPubblicazione;

    @Column(nullable = false, length = 4000, name="trama")
    private String trama;

    @Column(nullable = false, length = 300, name="copertina")
    private String copertina;


    public Libro(){};
    public Libro(String titolo, String isbn, String dataPubblicazione, String trama, String copertina) {
        this.titolo = titolo;
        this.isbn = isbn;
        this.dataPubblicazione = dataPubblicazione;
        this.trama = trama;
        this.copertina = copertina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDataPubblicazione() {
        return dataPubblicazione;
    }

    public void setDataPubblicazione(String dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }

    public String getTrama() {
        return trama;
    }

    public void setTrama(String trama) {
        this.trama = trama;
    }

    public String getCopertina() {
        return copertina;
    }

    public void setCopertina(String copertina) {
        this.copertina = copertina;
    }


}
