/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.jdbc;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@NamedQueries({
    @NamedQuery(name=Iscrizioni.FIND_BY_CORSO, query="select e from Iscrizioni e where")
})
@Entity
@Table(name = "t_iscrizioni")

public class Iscrizioni implements Serializable {

    
    public static final String FIND_BY_CORSO = "iscrizione.findByCorso";
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_iscrizione")
    private Long id;

    
    @Column(name = "dataiscrizione")
    private LocalDateTime il;
    
    

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_anagrafica")
    private Anagrafica anagrafica;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_corso")
    private Corso corso;

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getIl() {
        return il;
    }

    public void setIl(LocalDateTime il) {
        this.il = il;
    }

    public Anagrafica getAnagrafica() {
        return anagrafica;
    }

    public void setAnagrafica(Anagrafica anagrafica) {
        this.anagrafica = anagrafica;
    }

    public Corso getCorso() {
        return corso;
    }

    public void setCorso(Corso corso) {
        this.corso = corso;
    }

    @Override
    public String toString() {
        return "Iscrizioni{" + "id=" + id + ", il=" + il + ", anagrafica=" + anagrafica + ", corso=" + corso + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Iscrizioni other = (Iscrizioni) obj;
        return Objects.equals(this.id, other.id);
    }

}
