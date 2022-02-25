/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionelibreria;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author tss
 */
// Classe Biblioteca senza costruttore con metodo vuoto
public class Biblioteca {

    private Set<Book> libri = new LinkedHashSet<>();

//metodi aggiungo libro
    public boolean addBook(Book libro) {
        boolean presente = libri.contains(libro);
        if (presente) {
            System.out.println("Libro già presente, da non aggiungere");
            return false;

        }
        libri.add(libro);
        System.out.println(libro);
        return true;
    }

    public Set<Book> getLibri() {
        return libri;
    }

    public boolean loanBook(Book libro) {
        boolean presente = libri.contains(libro);
        if (presente && libro.isPrestato() == false) {
            System.out.println("libro non prestato, presente in libreria");
            libro.setPrestato(true);//posso prestare il libro e setto lo stato del libro come non disponibile
            return true;
        } else if (libro.isPrestato() == true) {
            ///libro non presente in libreria 
            System.out.println("libro è stato prestato");

        } else if (!presente) {

            throw new IllegalArgumentException("lancia eccezione");

        }
        return false;
    }

    public boolean returnBook(Book libro) {
        boolean presente = libri.contains(libro);

        if (libro.isPrestato() == false) {

            throw new IllegalArgumentException("lancia eccezione, libro non prestato");

        } else {

            System.out.println("libro prestato");
        }

        return true;
    }

    public void printloanBook(Book libro) {
        for (Book book : libri) {
            if (libro.isPrestato() == true) {
                System.out.println(libro);
            }

        }
    }
}