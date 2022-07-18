/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.bkmapp.entity;

import it.tss.bkmapp.adapters.EtichettaTypeAdapter;
import it.tss.bkmapp.adapters.UserTypeAdapter;
import java.util.Set;
import java.util.TreeSet;
import javax.json.bind.annotation.JsonbTransient;
import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author pc
 */

@Entity
@Table(name = "bookmark")
public class Bookmark extends BaseEntity {
    
   

    @NotBlank
    @Column(name="descrizione",nullable = false) 
    private String description;

    @NotBlank
    @Column(name = "link", nullable = false)
    private String link;

    @JsonbTransient
    @ManyToMany
    @Column(name = "etichette")
    private Set<Etichetta> etichette = new TreeSet<>();

    @Column(name = "condiviso", nullable = false)
    private boolean shared;

    @JsonbTypeAdapter(UserTypeAdapter.class)
    @ManyToOne(optional = false)
    @JoinColumn(name = "proprietario")
    private Author author;

    public String getDescription() {
        return description;
    }

    public void setDescription(String descrizione) {
        this.description = descrizione;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Set<Etichetta> getEtichette() {
        return etichette;
    }

    public void setEtichette(Set<Etichetta> etichette) {
        this.etichette = etichette;
    }

    public boolean isShared() {
        return shared;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Bookmark{" + "id =" + id + "descrizione=" + description + ", link=" + link + ", etichette=" + etichette + ", shared=" + shared + ", author=" + author + '}';
    }

}
