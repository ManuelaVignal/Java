/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionelibreria;

import java.util.Objects;

/**
 *
 * @author tss
 */
public class Book {
    
    //dichiarazione attributi

    private final String titolo;
    private boolean prestato = false;
  
    
    //costruttore del libro

    public Book(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.titolo);
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
        final Book other = (Book) obj;
        return Objects.equals(this.titolo, other.titolo);
    }

    public void setPrestato(boolean prestato) {
        this.prestato = prestato;
    }

    public String getTitolo() {
        return titolo;
    }

    public boolean isPrestato() {
        return prestato;
    }

    @Override
    public String toString() {
        return "il titolo del libro è =" + titolo + '}';
    }

}
