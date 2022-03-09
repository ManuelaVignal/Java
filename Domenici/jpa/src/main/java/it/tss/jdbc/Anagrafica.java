package it.tss.jdbc;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author tss
 */
@Entity
@Table(name = "t_anagrafiche")

public class Anagrafica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_anagrafica")
    

    private Long id_anagrafica;
    private String cognome;
    private String nome;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pv")
    private Provincia pv;

    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id_anagrafica);
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
        final Anagrafica other = (Anagrafica) obj;
        return Objects.equals(this.id_anagrafica, other.id_anagrafica);
    }

  

    public Long getId_anagrafica() {
        return id_anagrafica;
    }

    public void setId_anagrafica(Long id_anagrafica) {
        this.id_anagrafica = id_anagrafica;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Provincia getPv() {
        return pv;
    }

    public void setPv(Provincia pv) {
        this.pv = pv;
    }

    @Override
    public String toString() {
        return "Anagrafica{" + "id_anagrafica=" + id_anagrafica + ", cognome=" + cognome + ", nome=" + nome + ", pv=" + pv + '}';
    }
    
}
