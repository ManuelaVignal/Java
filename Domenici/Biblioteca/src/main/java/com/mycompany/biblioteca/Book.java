/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author pc
 */
public class Book {

    //attributi della classe Book
    private final String titolo;
    private LocalDateTime data;
    private boolean loan;

    // Costruttore della classe Book (Libro)
    public Book(String titolo) {
        this.titolo = titolo;
    }

    // i metodi della classe get/set/Override e hash ed equals per il titolo
    public String getTitolo() {
        return titolo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public boolean isLoan() {
        return loan;
    }

    public void setLoan(boolean loan) {
        this.loan = loan;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.titolo);
        return hash;
    }

    @Override
    public String toString() {
        return "Book{" + "titolo=" + titolo + ", data=" + data + ", loan=" + loan + '}';
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

}
