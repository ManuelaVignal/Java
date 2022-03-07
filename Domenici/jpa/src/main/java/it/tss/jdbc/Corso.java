/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.jdbc;

import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
//definire il mapping
@Entity
@Table(name = "t_corsi")

public class Corso {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name = "id_corso")
    private Long id;

    @Column(name = "titolocorso")
    private String titolo;

    @Column(name = "descrizionecorso")
    private String descrizione;

    @Column(name = "datainizio")
    private LocalDate inizio;

    @Column(name = "duratacorso")
    private Integer durata;

    @Column(name = "costocorso", precision = 6, scale = 2)
    private BigDecimal costo;

    @Column(name = "datacreazione")
    private LocalDate creatoil;

    public Corso() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public LocalDate getInizio() {
        return inizio;
    }

    public void setInizio(LocalDate inizio) {
        this.inizio = inizio;
    }

    public Integer getDurata() {
        return durata;
    }

    public void setDurata(Integer durata) {
        this.durata = durata;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public LocalDate getCreatoil() {
        return creatoil;
    }

    public void setCreatoil(LocalDate creatoil) {
        this.creatoil = creatoil;
    }

    @Override
    public String toString() {
        return "Corso{" + "id=" + id + ", titolo=" + titolo + ", descrizione=" + descrizione + ", inizio=" + inizio + ", durata=" + durata + ", costo=" + costo + ", creatoil=" + creatoil + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Corso other = (Corso) obj;
        return Objects.equals(this.id, other.id);
    }

}